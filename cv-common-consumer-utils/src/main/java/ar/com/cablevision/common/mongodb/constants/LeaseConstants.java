package ar.com.cablevision.common.mongodb.constants;

public enum LeaseConstants {

    ID_PARAMETER("_id"),
    MACADDRESS_PARAMETER("macAddress"),
    DATE_PARAMETER("date"),
    HISTORY_PARAMETER("history");

    private final String value;

    LeaseConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
