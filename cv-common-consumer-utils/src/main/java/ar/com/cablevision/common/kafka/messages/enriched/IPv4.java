package ar.com.cablevision.common.kafka.messages.enriched;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class IPv4 extends Lease {

    private static final long serialVersionUID = 8799656478674716638L;

    public IPv4(){
    }

    public IPv4(@JsonProperty("ipAddress") String ipAddress,
                @JsonProperty("macAddress") String macAddress,
                @JsonProperty("hostname") String hostname,
                @JsonProperty("date") Date date,
                @JsonProperty("macRelay") String macRelay,
                @JsonProperty("leaseId") Long leaseId,
                @JsonProperty("docsisSupport") String docsisSupport,
                @JsonProperty("clientId") Long clientId,
                @JsonProperty("idcmts") String idcmts,
                @JsonProperty("rebootDate") Date rebootDate,
                @JsonProperty("requestType") Integer requestType,
                @JsonProperty("iddsp") Long iddsp) {
        super(ipAddress, macAddress, hostname, date, macRelay, leaseId, docsisSupport, clientId, idcmts, rebootDate, requestType, iddsp);
    }
}
