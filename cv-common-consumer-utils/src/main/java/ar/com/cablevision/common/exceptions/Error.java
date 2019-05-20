package ar.com.cablevision.common.exceptions;

public enum Error {

    KAFKA_IDLE_ERROR(1000, "Consumer is idle."),
    TABLE_NOT_EXIST(1001, "No such table found: "),
    OBJECT_SERIALIZATION_ERROR(1002, "Object could not be parsed.");

    private final int code;
    private final String description;

    private Error(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}
