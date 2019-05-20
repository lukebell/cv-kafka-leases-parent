package ar.com.cablevision.common.exceptions;

import ar.com.cablevision.common.snmp.SNMPTrapGeneratorClient;

public class ProcessException extends RuntimeException {

    private int errorCode;

    public ProcessException() {
        super();
    }

    public ProcessException(String message) {
        super(message);
    }

    public ProcessException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProcessException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ProcessException(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public static void main(String[] args) {
        //SNMPTrapGeneratorClient.sendSnmpV3Trap();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getMessage() {
        return "Error Code: [" + getErrorCode() + "] Message: [" + super.getMessage() + "]";
    }

    public int getErrorCode() {
        return errorCode;
    }
}