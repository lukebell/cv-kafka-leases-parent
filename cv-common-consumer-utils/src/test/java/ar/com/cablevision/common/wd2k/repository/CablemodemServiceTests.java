package ar.com.cablevision.common.wd2k.repository;

import ar.com.cablevision.common.wd2k.domain.Cablemodem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(locations="classpath:config/wd2k-db.properties")
public class CablemodemServiceTests {

    @Autowired
    private CablemodemRepository cablemodemRepository;

    @Test
    public void findIdClienteByMacAddress() throws Exception {
        Set<String> macAddresses = new HashSet<>();
        macAddresses.add("01:06:14:5b:d1:33:c9:95");
        macAddresses.add("01:06:bc:d1:65:7e:21:d3");
        macAddresses.add("01:06:48:f7:c0:0d:46:fc");
        macAddresses.add("01:06:48:f7:c0:0c:75:f6");
        macAddresses.add("01:06:38:6b:bb:df:36:fa");

        List<Cablemodem> cablemodems = cablemodemRepository.findIdClienteByMacAddress(macAddresses);

        assertThat(cablemodems.get(0).getIdCliente().equals("5395957"));
        assertThat(cablemodems.get(1).getIdCliente().equals("3048156"));
        assertThat(cablemodems.get(2).getIdCliente().equals("1984856"));
        assertThat(cablemodems.get(3).getIdCliente().equals("3017594"));
        assertThat(cablemodems.get(4).getIdCliente().equals("5395958"));

    }
}
