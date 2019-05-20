package ar.com.cablevision.common.wd2k.repository;

import ar.com.cablevision.common.wd2k.domain.IPv6Lease;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(locations="classpath:config/wd2k-db.properties")
public class IPv6LeaseServiceTests {

    @Autowired
    private IPv6LeaseRepository iPv6LeaseService;

    @Test
    public void existsLeases() throws Exception {

        Map<Long, IPv6Lease> leases = new ConcurrentHashMap<>();

        leases.put(12337409644L, new IPv6Lease("172.26.244.227", "01:06:00:23:be:f4:e8:d8", "MTA", new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2014-06-13").getTime()), "00:23:be:f4:e8:d6", 12337409643L, "N/D", null, "61.000000000000000", null, 5, null, null, null, null, null));
        leases.put(12337409643L, new IPv6Lease("172.26.244.228", "01:06:00:23:be:f4:e8:d8", "MTA", new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2014-06-13").getTime()), "00:23:be:f4:e8:d6", 12337409644L, "N/D", null, "61.000000000000000", null, 5, null, null, null, null, null));

        List<Long> idLeases = iPv6LeaseService.existsLeases(leases);

        assertThat(idLeases.get(1).equals(leases.get(12337409643L).getIdLease()));
        assertThat(idLeases.get(0).equals(leases.get(12337409644L).getIdLease()));

    }
}
