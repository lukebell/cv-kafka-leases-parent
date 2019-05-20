package ar.com.cablevision.kafka.manager.strategy;

import ar.com.cablevision.common.wd2k.domain.IPv6Lease;
import ar.com.cablevision.common.wd2k.repository.IPv6LeaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.cglib.core.Predicate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class IPv6LeaseStrategy extends LeaseStrategy<IPv6Lease> {

    private static final Logger LOGGER = LoggerFactory.getLogger(IPv6LeaseStrategy.class);

    @Autowired
    private IPv6LeaseRepository iPv6LeaseRepository;

    @Override
    @SuppressWarnings("unchecked")
    public List<IPv6Lease> checkLeases(final Map<Long, IPv6Lease> leases) throws Exception{

        final List<Long> idLeases = iPv6LeaseRepository.existsLeases(leases);
        final List<IPv6Lease> result = new ArrayList<>();
        result.addAll(leases.values());

        return (List<IPv6Lease>) CollectionUtils.filter(result, new Predicate() {
            @Override
            public boolean evaluate(Object o) {
                return !idLeases.contains(((IPv6Lease) o).getIdLease());
            }
        });
    }

    @Override
    public void writeLeases(Map<Long, IPv6Lease> leases) throws Exception {
        LOGGER.debug("Writing IPv6 leases");

        // Checks if leases exists
        List<IPv6Lease> leasesToPersist = checkLeases(leases);

        // Creates leases in batch
        iPv6LeaseRepository.createBatch(leasesToPersist);
        this.leases = new ConcurrentHashMap<>();
    }
}