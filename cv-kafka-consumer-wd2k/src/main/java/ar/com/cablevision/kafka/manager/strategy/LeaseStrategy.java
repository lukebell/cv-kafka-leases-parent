package ar.com.cablevision.kafka.manager.strategy;

import ar.com.cablevision.common.wd2k.domain.BaseLease;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public abstract class LeaseStrategy<K extends BaseLease> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeaseStrategy.class);

    protected Map<Long, K> leases = new ConcurrentHashMap<>();

    public abstract List<K> checkLeases(Map<Long, K> leases) throws Exception;

    public abstract void writeLeases(Map<Long, K> leases) throws Exception;

    public Map<Long, K> getLeases() {
        return leases;
    }

    public void setLeases(Map<Long, K> leases) {
        this.leases = leases;
    }
}
