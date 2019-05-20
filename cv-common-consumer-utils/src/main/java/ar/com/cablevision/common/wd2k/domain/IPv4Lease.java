package ar.com.cablevision.common.wd2k.domain;

import java.sql.Date;

public class IPv4Lease extends BaseLease {

    private static final long serialVersionUID = 8799656478674716638L;

    public IPv4Lease(){
    }

    public IPv4Lease(String ipAddress,
                     String macAddress,
                     String hostname,
                     Date fecha,
                     String macRelay,
                     Long idLease,
                     String docsisSupport,
                     Long idCliente,
                     String idcmts,
                     Date fechaReboot,
                     Integer tipoPedido,
                     Long iddsp) {
        super(ipAddress, macAddress, hostname, fecha, macRelay, idLease, docsisSupport, idCliente, idcmts, fechaReboot, tipoPedido, iddsp);
    }
}
