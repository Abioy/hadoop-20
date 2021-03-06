/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.apache.hadoop.corona;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Cluster is composed of ClusterNodes that offer resources to the
 * ClusterManager. These resources are in turn requested by sessions.
 * resourceInfos is a map of app-specific information with the key
 * being the resource name and the value being the app-specific
 * information.
 */
public class ClusterNodeInfo implements org.apache.thrift.TBase<ClusterNodeInfo, ClusterNodeInfo._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ClusterNodeInfo");

  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField ADDRESS_FIELD_DESC = new org.apache.thrift.protocol.TField("address", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField TOTAL_FIELD_DESC = new org.apache.thrift.protocol.TField("total", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField USED_FIELD_DESC = new org.apache.thrift.protocol.TField("used", org.apache.thrift.protocol.TType.STRUCT, (short)4);
  private static final org.apache.thrift.protocol.TField RESOURCE_INFOS_FIELD_DESC = new org.apache.thrift.protocol.TField("resourceInfos", org.apache.thrift.protocol.TType.MAP, (short)5);

  public String name; // required
  public InetAddress address; // required
  public ComputeSpecs total; // required
  public ComputeSpecs used; // required
  public Map<ResourceType,String> resourceInfos; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NAME((short)1, "name"),
    ADDRESS((short)2, "address"),
    TOTAL((short)3, "total"),
    USED((short)4, "used"),
    RESOURCE_INFOS((short)5, "resourceInfos");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // NAME
          return NAME;
        case 2: // ADDRESS
          return ADDRESS;
        case 3: // TOTAL
          return TOTAL;
        case 4: // USED
          return USED;
        case 5: // RESOURCE_INFOS
          return RESOURCE_INFOS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ADDRESS, new org.apache.thrift.meta_data.FieldMetaData("address", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, InetAddress.class)));
    tmpMap.put(_Fields.TOTAL, new org.apache.thrift.meta_data.FieldMetaData("total", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ComputeSpecs.class)));
    tmpMap.put(_Fields.USED, new org.apache.thrift.meta_data.FieldMetaData("used", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ComputeSpecs.class)));
    tmpMap.put(_Fields.RESOURCE_INFOS, new org.apache.thrift.meta_data.FieldMetaData("resourceInfos", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, ResourceType.class), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ClusterNodeInfo.class, metaDataMap);
  }

  public ClusterNodeInfo() {
  }

  public ClusterNodeInfo(
    String name,
    InetAddress address,
    ComputeSpecs total)
  {
    this();
    this.name = name;
    this.address = address;
    this.total = total;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ClusterNodeInfo(ClusterNodeInfo other) {
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetAddress()) {
      this.address = new InetAddress(other.address);
    }
    if (other.isSetTotal()) {
      this.total = new ComputeSpecs(other.total);
    }
    if (other.isSetUsed()) {
      this.used = new ComputeSpecs(other.used);
    }
    if (other.isSetResourceInfos()) {
      Map<ResourceType,String> __this__resourceInfos = new HashMap<ResourceType,String>();
      for (Map.Entry<ResourceType, String> other_element : other.resourceInfos.entrySet()) {

        ResourceType other_element_key = other_element.getKey();
        String other_element_value = other_element.getValue();

        ResourceType __this__resourceInfos_copy_key = other_element_key;

        String __this__resourceInfos_copy_value = other_element_value;

        __this__resourceInfos.put(__this__resourceInfos_copy_key, __this__resourceInfos_copy_value);
      }
      this.resourceInfos = __this__resourceInfos;
    }
  }

  public ClusterNodeInfo deepCopy() {
    return new ClusterNodeInfo(this);
  }

  @Override
  public void clear() {
    this.name = null;
    this.address = null;
    this.total = null;
    this.used = null;
    this.resourceInfos = null;
  }

  public String getName() {
    return this.name;
  }

  public ClusterNodeInfo setName(String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public InetAddress getAddress() {
    return this.address;
  }

  public ClusterNodeInfo setAddress(InetAddress address) {
    this.address = address;
    return this;
  }

  public void unsetAddress() {
    this.address = null;
  }

  /** Returns true if field address is set (has been assigned a value) and false otherwise */
  public boolean isSetAddress() {
    return this.address != null;
  }

  public void setAddressIsSet(boolean value) {
    if (!value) {
      this.address = null;
    }
  }

  public ComputeSpecs getTotal() {
    return this.total;
  }

  public ClusterNodeInfo setTotal(ComputeSpecs total) {
    this.total = total;
    return this;
  }

  public void unsetTotal() {
    this.total = null;
  }

  /** Returns true if field total is set (has been assigned a value) and false otherwise */
  public boolean isSetTotal() {
    return this.total != null;
  }

  public void setTotalIsSet(boolean value) {
    if (!value) {
      this.total = null;
    }
  }

  public ComputeSpecs getUsed() {
    return this.used;
  }

  public ClusterNodeInfo setUsed(ComputeSpecs used) {
    this.used = used;
    return this;
  }

  public void unsetUsed() {
    this.used = null;
  }

  /** Returns true if field used is set (has been assigned a value) and false otherwise */
  public boolean isSetUsed() {
    return this.used != null;
  }

  public void setUsedIsSet(boolean value) {
    if (!value) {
      this.used = null;
    }
  }

  public int getResourceInfosSize() {
    return (this.resourceInfos == null) ? 0 : this.resourceInfos.size();
  }

  public void putToResourceInfos(ResourceType key, String val) {
    if (this.resourceInfos == null) {
      this.resourceInfos = new HashMap<ResourceType,String>();
    }
    this.resourceInfos.put(key, val);
  }

  public Map<ResourceType,String> getResourceInfos() {
    return this.resourceInfos;
  }

  public ClusterNodeInfo setResourceInfos(Map<ResourceType,String> resourceInfos) {
    this.resourceInfos = resourceInfos;
    return this;
  }

  public void unsetResourceInfos() {
    this.resourceInfos = null;
  }

  /** Returns true if field resourceInfos is set (has been assigned a value) and false otherwise */
  public boolean isSetResourceInfos() {
    return this.resourceInfos != null;
  }

  public void setResourceInfosIsSet(boolean value) {
    if (!value) {
      this.resourceInfos = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case ADDRESS:
      if (value == null) {
        unsetAddress();
      } else {
        setAddress((InetAddress)value);
      }
      break;

    case TOTAL:
      if (value == null) {
        unsetTotal();
      } else {
        setTotal((ComputeSpecs)value);
      }
      break;

    case USED:
      if (value == null) {
        unsetUsed();
      } else {
        setUsed((ComputeSpecs)value);
      }
      break;

    case RESOURCE_INFOS:
      if (value == null) {
        unsetResourceInfos();
      } else {
        setResourceInfos((Map<ResourceType,String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NAME:
      return getName();

    case ADDRESS:
      return getAddress();

    case TOTAL:
      return getTotal();

    case USED:
      return getUsed();

    case RESOURCE_INFOS:
      return getResourceInfos();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NAME:
      return isSetName();
    case ADDRESS:
      return isSetAddress();
    case TOTAL:
      return isSetTotal();
    case USED:
      return isSetUsed();
    case RESOURCE_INFOS:
      return isSetResourceInfos();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ClusterNodeInfo)
      return this.equals((ClusterNodeInfo)that);
    return false;
  }

  public boolean equals(ClusterNodeInfo that) {
    if (that == null)
      return false;

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_address = true && this.isSetAddress();
    boolean that_present_address = true && that.isSetAddress();
    if (this_present_address || that_present_address) {
      if (!(this_present_address && that_present_address))
        return false;
      if (!this.address.equals(that.address))
        return false;
    }

    boolean this_present_total = true && this.isSetTotal();
    boolean that_present_total = true && that.isSetTotal();
    if (this_present_total || that_present_total) {
      if (!(this_present_total && that_present_total))
        return false;
      if (!this.total.equals(that.total))
        return false;
    }

    boolean this_present_used = true && this.isSetUsed();
    boolean that_present_used = true && that.isSetUsed();
    if (this_present_used || that_present_used) {
      if (!(this_present_used && that_present_used))
        return false;
      if (!this.used.equals(that.used))
        return false;
    }

    boolean this_present_resourceInfos = true && this.isSetResourceInfos();
    boolean that_present_resourceInfos = true && that.isSetResourceInfos();
    if (this_present_resourceInfos || that_present_resourceInfos) {
      if (!(this_present_resourceInfos && that_present_resourceInfos))
        return false;
      if (!this.resourceInfos.equals(that.resourceInfos))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(ClusterNodeInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    ClusterNodeInfo typedOther = (ClusterNodeInfo)other;

    lastComparison = Boolean.valueOf(isSetName()).compareTo(typedOther.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, typedOther.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAddress()).compareTo(typedOther.isSetAddress());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAddress()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.address, typedOther.address);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTotal()).compareTo(typedOther.isSetTotal());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTotal()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.total, typedOther.total);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUsed()).compareTo(typedOther.isSetUsed());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUsed()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.used, typedOther.used);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetResourceInfos()).compareTo(typedOther.isSetResourceInfos());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResourceInfos()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.resourceInfos, typedOther.resourceInfos);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    org.apache.thrift.protocol.TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == org.apache.thrift.protocol.TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // NAME
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.name = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // ADDRESS
          if (field.type == org.apache.thrift.protocol.TType.STRUCT) {
            this.address = new InetAddress();
            this.address.read(iprot);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // TOTAL
          if (field.type == org.apache.thrift.protocol.TType.STRUCT) {
            this.total = new ComputeSpecs();
            this.total.read(iprot);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // USED
          if (field.type == org.apache.thrift.protocol.TType.STRUCT) {
            this.used = new ComputeSpecs();
            this.used.read(iprot);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // RESOURCE_INFOS
          if (field.type == org.apache.thrift.protocol.TType.MAP) {
            {
              org.apache.thrift.protocol.TMap _map0 = iprot.readMapBegin();
              this.resourceInfos = new HashMap<ResourceType,String>(2*_map0.size);
              for (int _i1 = 0; _i1 < _map0.size; ++_i1)
              {
                ResourceType _key2; // required
                String _val3; // required
                _key2 = ResourceType.findByValue(iprot.readI32());
                _val3 = iprot.readString();
                this.resourceInfos.put(_key2, _val3);
              }
              iprot.readMapEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.name != null) {
      oprot.writeFieldBegin(NAME_FIELD_DESC);
      oprot.writeString(this.name);
      oprot.writeFieldEnd();
    }
    if (this.address != null) {
      oprot.writeFieldBegin(ADDRESS_FIELD_DESC);
      this.address.write(oprot);
      oprot.writeFieldEnd();
    }
    if (this.total != null) {
      oprot.writeFieldBegin(TOTAL_FIELD_DESC);
      this.total.write(oprot);
      oprot.writeFieldEnd();
    }
    if (this.used != null) {
      if (isSetUsed()) {
        oprot.writeFieldBegin(USED_FIELD_DESC);
        this.used.write(oprot);
        oprot.writeFieldEnd();
      }
    }
    if (this.resourceInfos != null) {
      if (isSetResourceInfos()) {
        oprot.writeFieldBegin(RESOURCE_INFOS_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.STRING, this.resourceInfos.size()));
          for (Map.Entry<ResourceType, String> _iter4 : this.resourceInfos.entrySet())
          {
            oprot.writeI32(_iter4.getKey().getValue());
            oprot.writeString(_iter4.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ClusterNodeInfo(");
    boolean first = true;

    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("address:");
    if (this.address == null) {
      sb.append("null");
    } else {
      sb.append(this.address);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("total:");
    if (this.total == null) {
      sb.append("null");
    } else {
      sb.append(this.total);
    }
    first = false;
    if (isSetUsed()) {
      if (!first) sb.append(", ");
      sb.append("used:");
      if (this.used == null) {
        sb.append("null");
      } else {
        sb.append(this.used);
      }
      first = false;
    }
    if (isSetResourceInfos()) {
      if (!first) sb.append(", ");
      sb.append("resourceInfos:");
      if (this.resourceInfos == null) {
        sb.append("null");
      } else {
        sb.append(this.resourceInfos);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (name == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'name' was not present! Struct: " + toString());
    }
    if (address == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'address' was not present! Struct: " + toString());
    }
    if (total == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'total' was not present! Struct: " + toString());
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

}

