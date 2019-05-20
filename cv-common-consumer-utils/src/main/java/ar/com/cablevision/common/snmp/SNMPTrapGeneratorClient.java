package ar.com.cablevision.common.snmp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snmp4j.CommandResponder;
import org.snmp4j.CommandResponderEvent;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.ScopedPDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.UserTarget;
import org.snmp4j.mp.MPv3;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.security.AuthMD5;
import org.snmp4j.security.PrivAES128;
import org.snmp4j.security.PrivAES192;
import org.snmp4j.security.SecurityLevel;
import org.snmp4j.security.SecurityModels;
import org.snmp4j.security.SecurityProtocols;
import org.snmp4j.security.USM;
import org.snmp4j.security.UsmUser;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.IpAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.util.DefaultPDUFactory;

public class SNMPTrapGeneratorClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(SNMPTrapGeneratorClient.class);

    private static final String COMMUNITY = "public";
    private static final String TRAP_OID = ".1.3.6.1.2.1.1.6";
    private static final String IP_ADDRESS = "192.168.248.129";
    private static final int PORT = 162;

/*    public static void main(String args[]) {
        sendSnmpV1V2Trap(SnmpConstants.version1);
        sendSnmpV1V2Trap(SnmpConstants.version2c);
        sendSnmpV3Trap();
    } */

    /**
     * This methods sends the V1/V2 trap
     *
     * @param version
     */
    public static void sendSnmpV1V2Trap(int version) {
        // send trap
        sendV1orV2Trap(version, COMMUNITY, IP_ADDRESS, PORT);
    }

    private static PDU createPdu(int snmpVersion) {
        PDU pdu = DefaultPDUFactory.createPDU(snmpVersion);
        if (snmpVersion == SnmpConstants.version1) {
            pdu.setType(PDU.V1TRAP);
        } else {
            pdu.setType(PDU.TRAP);
        }
        pdu.add(new VariableBinding(SnmpConstants.sysUpTime));
        pdu.add(new VariableBinding(SnmpConstants.snmpTrapOID, new OID(TRAP_OID)));
        pdu.add(new VariableBinding(SnmpConstants.snmpTrapAddress, new IpAddress(IP_ADDRESS)));
        pdu.add(new VariableBinding(new OID(TRAP_OID), new OctetString("Major")));
        return pdu;
    }

    public static void sendV1orV2Trap(int snmpVersion, String community, String ipAddress, int port) {
        try {
            // create v1/v2 PDU
            PDU snmpPDU = createPdu(snmpVersion);

            // Create Transport Mapping
            TransportMapping<?> transport = new DefaultUdpTransportMapping();
            transport.listen();

            // Create Target
            CommunityTarget comtarget = new CommunityTarget();
            comtarget.setCommunity(new OctetString(community));
            comtarget.setVersion(snmpVersion);
            comtarget.setAddress(new UdpAddress(ipAddress + "/" + port));
            comtarget.setRetries(2);
            comtarget.setTimeout(5000);

            // Send the PDU
            Snmp snmp = new Snmp(transport);
            snmp.send(snmpPDU, comtarget);
            LOGGER.debug("Sent Trap to (IP:Port)=> " + ipAddress + ":" + port);
            snmp.close();
        } catch (Exception e) {
            LOGGER.error("Error in Sending Trap to (IP:Port)=> " + ipAddress + ":" + port + " - Exception Message: " + e.getMessage());
        }
    }

    /**
     * Sends the v3 trap
     */
    public static void sendSnmpV3Trap() {
        try {
            Address targetAddress = GenericAddress.parse("udp:" + IP_ADDRESS + "/" + PORT);
            TransportMapping<?> transport = new DefaultUdpTransportMapping();
            Snmp snmp = new Snmp(transport);
            USM usm = new USM(SecurityProtocols.getInstance().addDefaultProtocols(), new OctetString(MPv3.createLocalEngineID()), 0);
            SecurityProtocols.getInstance().addPrivacyProtocol(new PrivAES192());
            SecurityModels.getInstance().addSecurityModel(usm);
            transport.listen();

            snmp.getUSM().addUser(new OctetString("MD5DES"),
                    new UsmUser(
                            new OctetString("MD5DES"), AuthMD5.ID,
                            new OctetString("UserName"), PrivAES128.ID,
                            new OctetString("UserName")
                    )
            );

            // Create Target
            UserTarget target = new UserTarget();
            target.setAddress(targetAddress);
            target.setRetries(1);
            target.setTimeout(11500);
            target.setVersion(SnmpConstants.version3);
            target.setSecurityLevel(SecurityLevel.AUTH_PRIV);
            target.setSecurityName(new OctetString("MD5DES"));

            // Create PDU for V3
            ScopedPDU pdu = new ScopedPDU();
            pdu.setType(ScopedPDU.NOTIFICATION);
            pdu.add(new VariableBinding(SnmpConstants.sysUpTime));
            pdu.add(new VariableBinding(SnmpConstants.snmpTrapOID, SnmpConstants.linkDown));
            pdu.add(new VariableBinding(new OID(TRAP_OID), new OctetString("Major")));

            // Send the PDU
            snmp.send(pdu, target);
            LOGGER.debug("Sending Trap to (IP:Port)=> " + IP_ADDRESS + ":" + PORT);
            snmp.addCommandResponder(new CommandResponder() {
                public void processPdu(CommandResponderEvent arg0) {
                    LOGGER.debug(String.valueOf(arg0));
                }
            });
            snmp.close();
        } catch (Exception e) {
            LOGGER.error("Error in Sending Trap to (IP:Port)=> " + IP_ADDRESS + ":" + PORT + " - Exception Message: " + e.getMessage());
        }
    }
}