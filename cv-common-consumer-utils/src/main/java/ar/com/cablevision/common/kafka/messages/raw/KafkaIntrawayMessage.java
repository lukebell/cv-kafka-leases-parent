package ar.com.cablevision.common.kafka.messages.raw;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = JsonTypeInfo.As.PROPERTY, property = "property")
public class KafkaIntrawayMessage implements Serializable {

    private String topic;
    private Integer partition;
    private Long offset;
    private String key;
    private RawLease value;

    /**
     * Constructor
     */
    public KafkaIntrawayMessage(){
    }

    /**
     * Constructor
     *
     * @param topic The message consumer message
     * @param partition The partition assigned
     * @param offset The message offset
     * @param key The message key
     * @param value The message value
     */
    @JsonCreator
    public KafkaIntrawayMessage(@JsonProperty("topic") String topic,
                                @JsonProperty("partition") Integer partition,
                                @JsonProperty("offset") Long offset,
                                @JsonProperty("key") String key,
                                @JsonProperty("value") RawLease value) {
        this.topic = topic;
        this.partition = partition;
        this.offset = offset;
        this.key = key;
        this.value = value;
    }

    public String getTopic() {
        return topic;
    }

    public Integer getPartition() {
        return partition;
    }

    public Long getOffset() {
        return offset;
    }

    public String getKey() {
        return key;
    }

    public RawLease getValue() {
        return value;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setPartition(Integer partition) {
        this.partition = partition;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(RawLease value) {
        this.value = value;
    }
}
