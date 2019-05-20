package ar.com.cablevision.common.mongodb.domain;

import java.util.Date;

public class IPv4Lease extends BaseLease {

    private static final long serialVersionUID = 8799656478674716638L;

    public IPv4Lease(){
    }

    public IPv4Lease(String ipAddress,
                     String hostname,
                     Date date,
                     String macRelay,
                     Long leaseId,
                     String docsisSupport,
                     Long clientId,
                     String cmtsId,
                     Date rebootDate,
                     Integer requestType,
                     Long dspId) {
        super(ipAddress, hostname, date, macRelay, leaseId, docsisSupport, clientId, cmtsId, rebootDate, requestType, dspId);
    }
}
