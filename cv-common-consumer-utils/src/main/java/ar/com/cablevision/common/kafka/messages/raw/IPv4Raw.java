package ar.com.cablevision.common.kafka.messages.raw;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class IPv4Raw extends IPRaw {

    protected String macMta;

    public IPv4Raw() {
    }

    @JsonCreator
    public IPv4Raw(@JsonProperty("IPADDRESS") String ipAddress,
                   @JsonProperty("MACADDRESS") String macAddress,
                   @JsonProperty("HOSTNAME") String hostname,
                   @JsonProperty("FECHA") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyy-MM-dd:HH:mm:ss", timezone="America/Argentina/Buenos_Aires") Date fecha,
                   @JsonProperty("MACRELAY") String macRelay,
                   @JsonProperty("IDLEASE") Long idLease,
                   @JsonProperty("DOCSIS_SUPPORT") String docsisSupport,
                   @JsonProperty("IDCLIENTE") Long idCliente,
                   @JsonProperty("IDCMTS") Long idCMTS,
                   @JsonProperty("FECHA_REBOOT") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyy-MM-dd:HH:mm:ss", timezone="America/Argentina/Buenos_Aires") Date fechaReboot,
                   @JsonProperty("TIPO_PEDIDO") Integer tipoPedido,
                   @JsonProperty("IDDSP") Long idDSP,
                   @JsonProperty("IDLEASEIW") Long idLeaseIW,
                   @JsonProperty("SRC") String src,
                   @JsonProperty("MACMTA") String macMta) {
        super(ipAddress, macAddress, hostname, fecha, macRelay, idLease, docsisSupport, idCliente, idCMTS, fechaReboot, tipoPedido, idDSP, idLeaseIW, src);
        this.macMta = macMta;
    }

    public void setMacMta(String macMta) {
        this.macMta = macMta;
    }

    public String getMacMta() {
        return macMta;
    }

    @Override
    public String toString() {
        return "IPRaw{" +
                "ipAddress='" + ipAddress + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", hostname='" + hostname + '\'' +
                ", date=" + fecha + '\'' +
                ", macRelay='" + macRelay + '\'' +
                ", leaseId=" + idLease + '\'' +
                ", docsisSupport='" + docsisSupport + '\'' +
                ", clientId=" + idCliente + '\'' +
                ", idCMTS=" + idCMTS + '\'' +
                ", rebootDate=" + fechaReboot + '\'' +
                ", requestType=" + tipoPedido + '\'' +
                ", idDSP=" + idDSP + '\'' +
                ", idLeaseIW=" + idLeaseIW + '\'' +
                ", src='" + src +  '\'' +
                ", macMta= " +  macMta + '\'' +
                '}';
    }
}
