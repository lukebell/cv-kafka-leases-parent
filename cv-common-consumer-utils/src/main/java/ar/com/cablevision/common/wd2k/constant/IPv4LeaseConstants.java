package ar.com.cablevision.common.wd2k.constant;

public enum IPv4LeaseConstants {

    IPADDRESS_COLUMN("IPADDRESS"),
    MACADDRESS_COLUMN("MACADDRESS"),
    HOSTNAME_COLUMN("HOSTNAME"),
    FECHA_COLUMN("FECHA"),
    MACRELAY_COLUMN("MACRELAY"),
    IDLEASE_COLUMN("IDLEASE"),
    DOCSIS_SUPPORT_COLUMN("DOCSIS_SUPPORT"),
    IDCLIENTE_COLUMN("IDCLIENTE"),
    IDCMTS_COLUMN("IDCMTS"),
    FECHA_REBOOT_COLUMN("FECHA_REBOOT"),
    TIPO_PEDIDO_COLUMN("TIPO_PEDIDO"),
    IDDSP_COLUMN("IDDSP"),

    IDLEASES_NAMED_PARAMETER("idLeases"),
    MINFECHA_NAMED_PARAMETER("minFecha"),
    MAXFECHA_NAMED_PARAMETER("maxFecha"),

    FIND_ALL_QUERY("SELECT * FROM \"INTRAWAY\".\"CM_LEASES\""),
    FIND_BY_ID_QUERY("SELECT * FROM \"INTRAWAY\".\"CM_LEASES\" WHERE IDLEASE=?"),
    INSERT_QUERY("INSERT INTO \"INTRAWAY\".\"CM_LEASES\" (IPADDRESS,MACADDRESS,HOSTNAME,FECHA,MACRELAY,IDLEASE," +
            "DOCSIS_SUPPORT,IDCLIENTE,IDCMTS,FECHA_REBOOT,TIPO_PEDIDO,IDDSP) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)"),
    EXISTS_IDLEASE_QUERY("SELECT /*+ rule index(cl idiwa_leases_pk) */ IDLEASE FROM \"INTRAWAY\".\"CM_LEASES\" WHERE FECHA BETWEEN :minFecha and :maxFecha AND IDLEASE IN (:idLeases)");

    private final String value;

    IPv4LeaseConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
