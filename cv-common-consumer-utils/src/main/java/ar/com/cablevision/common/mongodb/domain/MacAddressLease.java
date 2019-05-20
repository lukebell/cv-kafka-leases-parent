package ar.com.cablevision.common.mongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "leases")
public class MacAddressLease<T extends BaseLease> implements BaseEntity {

    @Id
    private String macAddress;

    @Field
    private IPv4Lease ipv4;

    @Field
    private IPv6Lease ipv6;

    @Field
    private List<T> history = new ArrayList<T>();

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public IPv4Lease getIpv4() {
        return ipv4;
    }

    public void setIpv4(IPv4Lease ipv4) {
        this.ipv4 = ipv4;
    }

    public IPv6Lease getIpv6() {
        return ipv6;
    }

    public void setIpv6(IPv6Lease ipv6) {
        this.ipv6 = ipv6;
    }

    public List<T> getHistory() {
        return history;
    }

    public void setHistory(List<T> history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "MacAddressLease{" +
                "macAddress='" + macAddress + '\'' +
                ", ipv4=" + ipv4 +
                ", ipv6=" + ipv6 +
                ", history=" + history +
                '}';
    }
}
