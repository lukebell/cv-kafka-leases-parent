package ar.com.cablevision.common.kafka.messages.enriched;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

public class KafkaLeaseMessage <K extends Lease> implements Serializable {

    private String type;

    @JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.EXTERNAL_PROPERTY, property="type", visible = true)
    @JsonSubTypes({
            @JsonSubTypes.Type(value= IPv4.class, name="IPv4"),
            @JsonSubTypes.Type(value= IPv4.class, name="IPv4"),
            @JsonSubTypes.Type(value= IPv4.class, name="IPv4"),
            @JsonSubTypes.Type(value= IPv6.class, name="IPv6")
    })
    private K lease;

    /**
     * Constructor
     */
    public KafkaLeaseMessage() {
    }

    /**
     * Constructor
     *
     * @param type The lease type
     * @param lease The lease
     */
    public KafkaLeaseMessage(@JsonProperty("type") String type,
                             @JsonProperty("lease") K lease) {
        this.type = type;
        this.lease = lease;
    }

    public K getLease() {
        return lease;
    }

    public void setLease(K lease) {
        this.lease = lease;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "KafkaLeaseMessage{" +
                ", type='" + type + '\'' +
                ", lease=" + lease +
                '}';
    }
}
