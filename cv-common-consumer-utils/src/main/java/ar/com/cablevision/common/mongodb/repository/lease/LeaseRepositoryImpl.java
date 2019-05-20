package ar.com.cablevision.common.mongodb.repository.lease;

import ar.com.cablevision.common.mongodb.domain.BaseLease;
import ar.com.cablevision.common.mongodb.domain.MacAddressLease;
import ar.com.cablevision.common.mongodb.repository.BaseRepositoryCustom;

import java.util.Collections;
import java.util.Comparator;

public class LeaseRepositoryImpl extends BaseRepositoryCustom implements LeaseRepositoryCustom {

    private static final int MAX_HISTORY_SIZE = 10;

    @Override
    @SuppressWarnings("unchecked")
    public void upsertCustom(MacAddressLease lease) throws Exception {

        MacAddressLease leaseToUpdate = mongoTemplate.findById(lease.getMacAddress(), MacAddressLease.class);

        if (leaseToUpdate != null) {
            // Sets IPv4
            if (lease.getIpv4() != null) {
                if (leaseToUpdate.getIpv4() == null || lease.getIpv4().getDate() != null && leaseToUpdate.getIpv4().getDate() != null &&
                        lease.getIpv4().getDate().after(leaseToUpdate.getIpv4().getDate())) {
                    leaseToUpdate.setIpv4(lease.getIpv4());
                }
            }
            // Sets Ipv6
            if (lease.getIpv6() != null) {
                if (leaseToUpdate.getIpv6() == null || lease.getIpv6().getDate() != null && leaseToUpdate.getIpv6().getDate() != null &&
                        lease.getIpv6().getDate().after(leaseToUpdate.getIpv6().getDate())) {
                    leaseToUpdate.setIpv6(lease.getIpv6());
                }
            }

            lease.getHistory().removeAll(leaseToUpdate.getHistory());
            lease.getHistory().addAll(leaseToUpdate.getHistory());

            // Order History by Date
            Collections.sort(lease.getHistory(), new Comparator<BaseLease>() {
                public int compare(BaseLease l1, BaseLease l2) {
                    return l1.getDate().compareTo(l2.getDate());
                }
            });

            // Limit History size
            while (lease.getHistory().size() > MAX_HISTORY_SIZE) {
                lease.getHistory().remove(0);
            }

            // Sets History
            leaseToUpdate.setHistory(lease.getHistory());
        }
        // Saves Object
        mongoTemplate.save(lease);
    }
}
