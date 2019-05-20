package ar.com.cablevision.common.kafka.messages.raw;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;

public class RawLease<K extends IPRaw> {

    private String table;
    private String op_type;
    private Date op_ts;
    private Date current_ts;
    private String pos;
    private K after;

    public RawLease(){
    }

    /**
     * Constructor
     *
     * @param table The lease table
     * @param op_type The type of the operation
     * @param op_ts The operation timestamp
     * @param current_ts The current timestamp
     * @param pos The message position
     * @param after The lease values
     */
    @JsonCreator
    public RawLease(@JsonProperty("table") String table,
                    @JsonProperty("op_type") String op_type,
                    @JsonProperty("op_ts") Date op_ts,
                    @JsonProperty("current_ts") @JsonFormat(timezone="America/Argentina/Buenos_Aires") Date current_ts,
                    @JsonProperty("pos") String pos,
                    @JsonProperty("after") K after) {
        this.table = table;
        this.op_type = op_type;
        this.op_ts = op_ts;
        this.current_ts = current_ts;
        this.pos = pos;
        this.after = after;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getOp_type() {
        return op_type;
    }

    public void setOp_type(String op_type) {
        this.op_type = op_type;
    }

    public Date getOp_ts() {
        return op_ts;
    }

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.SSSSSS")
    public void setOp_ts(Date op_ts) {
        this.op_ts = op_ts;
    }

    public Date getCurrent_ts() {
        return current_ts;
    }

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
    public void setCurrent_ts(Date current_ts) {
        this.current_ts = current_ts;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public K getAfter() {
        return after;
    }

    @JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.EXTERNAL_PROPERTY, property="table", visible = true)
    @JsonSubTypes({
            @JsonSubTypes.Type(value=IPv4Raw.class, name="CV.EXP_ESTB_LEASES_IPV4"),
            @JsonSubTypes.Type(value=IPv4Raw.class, name="CV.EXP_CM_LEASES_IPV4"),
            @JsonSubTypes.Type(value=IPv4Raw.class, name="CV.EXP_PKT_LEASES_IPV4"),
            @JsonSubTypes.Type(value=IPv6Raw.class, name="CV.EXP_CPE_LEASES_IPV6")
    })
    public void setAfter(K after) {
        this.after = after;
    }

    @Override
    public String toString() {
        return "RawLease{" +
                "table='" + table + '\'' +
                ", op_type='" + op_type + '\'' +
                ", op_ts=" + op_ts +
                ", current_ts=" + current_ts +
                ", pos='" + pos + '\'' +
                ", after=" + after +
                '}';
    }
}
