package ar.com.cablevision.kafka.manager.strategy;

import ar.com.cablevision.common.wd2k.domain.IPv4Lease;
import ar.com.cablevision.common.wd2k.repository.IPv4LeaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.cglib.core.Predicate;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class IPv4LeaseStrategy extends LeaseStrategy<IPv4Lease> {

    private static final Logger LOGGER = LoggerFactory.getLogger(IPv4LeaseStrategy.class);

    @Autowired
    private IPv4LeaseRepository iPv4LeaseRepository;

    @Override
    @SuppressWarnings("unchecked")
    public List<IPv4Lease> checkLeases(final Map<Long, IPv4Lease> leases) throws  Exception {

        final List<Long> idLeases = iPv4LeaseRepository.existsLeases(leases);
        final List<IPv4Lease> result = new ArrayList<>();
        result.addAll(leases.values());

        return (List<IPv4Lease>) CollectionUtils.filter(result, new Predicate() {
            @Override
            public boolean evaluate(Object o) {
                return !idLeases.contains(((IPv4Lease) o).getIdLease());
            }
        });
    }

    @Override
    public void writeLeases(Map<Long, IPv4Lease> leases) throws Exception {
        LOGGER.debug("Writing IPv4 leases");

        // Checks if leases exists
        List<IPv4Lease> leasesToPersist = checkLeases(leases);

        // Creates leases in batch
        iPv4LeaseRepository.createBatch(leasesToPersist);
        this.leases = new ConcurrentHashMap<>();
    }
}
