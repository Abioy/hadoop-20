namespace java org.apache.hadoop.corona

/**
 * Types of the resources that Corona manages.
 */
enum ResourceType {
  /** Map resource */
  MAP,
  /** Reduce resource */
  REDUCE,
  /** Federated jobtracker resource */
  JOBTRACKER,
}

/**
 * Generic end point for a service.
 */
struct InetAddress {
  1: required string    host,
  2: required i32       port,
}

/**
 * Standard set of resources offered by a computer
 */
struct ComputeSpecs {
  1: required i16               numCpus,
  2: optional i16               networkMBps,
  3: optional i32               memoryMB,
  4: optional i32               diskGB,
}

/**
 * A Cluster is composed of ClusterNodes that offer resources to the
 * ClusterManager. These resources are in turn requested by sessions.
 * resourceInfos is a map of app-specific information with the key
 * being the resource name and the value being the app-specific
 * information.
 */
struct ClusterNodeInfo {
  1: required string                    name,
  2: required InetAddress               address,
  3: required ComputeSpecs              total,
  4: optional ComputeSpecs              used,
  5: optional map<ResourceType, string> resourceInfos
}

typedef i32 ResourceRequestId

struct ResourceRequest {
  1: required ResourceRequestId id,
  2: optional list<string>      hosts,
  3: optional ComputeSpecs      specs,
  4: required ResourceType      type,
  5: optional list<string>      excludeHosts,
}

struct ResourceGrant {
  1: required ResourceRequestId id,
  2: required string            nodeName,
  3: required InetAddress       address,
  4: required i64               grantedTime,
  5: required ResourceType      type,
  6: optional string            appInfo
}

/**
 * Usage statistics about a resource granted to a session.
 * The statistics are treated incrementally, so if a session reports
 * statistics multiple times for a node, the statistics are added up
 * for that node.
 */
struct NodeUsageReport {
  1: required string            nodeName,
  2: required i32               numTotalTasks,
  3: required i32               numSucceeded,
  4: required i32               numKilled,
  5: required i32               numFailed,
  6: required i32               numTimeout,
  7: required i32               numSlow,
  8: required i32               numFailedConnections
}

enum SessionPriority {
  VERY_LOW = 0,
  LOW = 1,
  NORMAL = 2,
  HIGH = 3,
  VERY_HIGH = 4
}

/**
 * A Session is considered to be RUNNING from start() until end().
 * When a session ends - it's status is updated to any of the other
 * states (FAILED-KILLED) by the client.
 * A session may also be terminated on the server side. The only state
 * set on the server side right now is TIMED_OUT
 * A session may end itself if it finds itself in an inconsistent state -
 *   it ends with the KILLED_ABORTED state in that case.
 */
enum SessionStatus {
  RUNNING=1,
  FAILED,
  SUCCESSFUL,
  KILLED,
  TIMED_OUT,
  KILLED_ABORTED,
}

typedef string SessionHandle

struct SessionInfo {
  1: required InetAddress       address,
  2: required string            name,
  3: required string            userId,
  4: optional list<string>      groupIds,
  5: optional string            poolId,
  6: optional SessionPriority   priority,
  7: optional bool              noPreempt,
  8: optional string            url,
  9: optional i64               deadline
}

struct ClusterManagerInfo {
  1: required string            url,
  2: required string            jobHistoryLocation,
}

struct SessionRegistrationData {
  1: required SessionHandle              handle,
  2: required ClusterManagerInfo         clusterManagerInfo,
  3: required string                     pool,
}


exception InvalidSessionHandle {
  1: required string            handle
}

exception DisallowedNode {
  1: required string            host;
}

/**
 * The Session Driver manages the session for clients.
 * The APIs below are invoked by the ClusterManager to convey information back to the
 * SessionDriver asynchronously
 *
 * A sessionId is supplied for all calls in case the client is managing multiple sessions
 */
service SessionDriverService {
  void grantResource(1: SessionHandle handle, 2: list<ResourceGrant> granted),

  void revokeResource(1: SessionHandle handle, 2: list<ResourceGrant> revoked, 3: bool force),

  void processDeadNode(1: SessionHandle handle, 2: string node),
}

/**
 * Cluster Manager Service API.
 */
service ClusterManagerService {
  // Register a session start, return a handle to the session.
  SessionRegistrationData sessionStart(1: SessionInfo info),

  // Register a URL for the session. An extra call is provided because the URL
  // URL may depend on the sessionId obtained from sessionStart
  void sessionUpdateInfo(1: SessionHandle handle, 2: SessionInfo info) throws (1: InvalidSessionHandle e),

  // Notify session end.
  void sessionEnd(1: SessionHandle handle, 2: SessionStatus status) throws (1: InvalidSessionHandle e),

  // Heartbeat a session.
  void sessionHeartbeat(1: SessionHandle handle) throws (1: InvalidSessionHandle e),

  // Request additional resources. A request is required for each resource
  // requested.
  void requestResource(1: SessionHandle handle, 2: list<ResourceRequest> requestList) throws (1: InvalidSessionHandle e),

  // Release granted/requested resources.
  void releaseResource(1: SessionHandle handle, 2: list<ResourceRequestId> idList) throws (1: InvalidSessionHandle e),

  // Heartbeat a cluster node. This is an implicit advertisement of the node's resources
  void nodeHeartbeat(1: ClusterNodeInfo node) throws (1: DisallowedNode e),

  // Feedback from a session on the resources that it was given.
  void nodeFeedback(
    1: SessionHandle handle,
    2: list<ResourceType> resourceTypes,
    3: list<NodeUsageReport> stats) throws (1: InvalidSessionHandle e),

  // Refresh node information.
  void refreshNodes(),
}

/**
 * Corona TaskTracker Service API.
 */
service CoronaTaskTrackerService {
  // Purge all jobs relatd to this session
  void purgeSession(1: SessionHandle handle) throws (1: InvalidSessionHandle e),

  // Tell task tracker to reject all actions from this session
  void blacklistSession(1: SessionHandle handle) throws (1: InvalidSessionHandle e),
}
