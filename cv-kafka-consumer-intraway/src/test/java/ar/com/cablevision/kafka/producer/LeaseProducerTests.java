package ar.com.cablevision.kafka.producer;

import ar.com.cablevision.common.kafka.messages.enriched.IPv4;
import ar.com.cablevision.common.kafka.messages.enriched.IPv6;
import ar.com.cablevision.common.kafka.messages.enriched.KafkaLeaseMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.kafka.test.assertj.KafkaConditions.key;
import static org.springframework.kafka.test.assertj.KafkaConditions.partition;
import static org.springframework.kafka.test.assertj.KafkaConditions.value;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.config.ContainerProperties;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeaseProducerTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeaseProducerTests.class);

    private static final String KEY_TOPIC = "enrichedleases";

    @ClassRule
    public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, false, KEY_TOPIC);

    private static KafkaMessageListenerContainer<Integer, String> container = null;

    private static DefaultKafkaConsumerFactory<Integer, String> cf = null;

    @BeforeClass
    public static void setUp() throws Exception {
        final Map<String, Object> consumerProps = KafkaTestUtils.consumerProps("sampleConsumer", "false", embeddedKafka);
        consumerProps.put("auto.offset.reset", "earliest");
        cf = new DefaultKafkaConsumerFactory<>(consumerProps);
    }

    @AfterClass
    public static void tearDown() {
        container.stop();
    }

    @Test
    public void sendMessages() throws Exception {

        ContainerProperties containerProps = new ContainerProperties(KEY_TOPIC);

        final CountDownLatch latch = new CountDownLatch(2);

        containerProps.setMessageListener(new AcknowledgingMessageListener<Integer, String>() {

            @Override
            public void onMessage(ConsumerRecord<Integer, String> consumerRecord, Acknowledgment acknowledgment) {
                LOGGER.info("Receiving: " + consumerRecord);

                if(consumerRecord.key() == 0) {
                    assertThat(consumerRecord).has(key(0));
                    assertThat(consumerRecord).has(partition(0));
                    assertThat(consumerRecord).has(value("{\"type\":\"IPv4Raw\",\"lease\":{\"ipAddress\":\"99.99.99.1\",\"macAddress\":\"00-00-00-00-00-01\",\"hostname\":\"LOCALHOST\",\"date\":\"1969-12-31\",\"macRelay\":\"A1\",\"leaseId\":1,\"docsisSupport\":\"S1\",\"clientId\":1,\"rebootDate\":\"1969-12-31\",\"orderType\":4444,\"cmtsId\":\"3333\",\"dspId\":2222}}"));
                } else {
                    assertThat(consumerRecord).has(key(1));
                    assertThat(consumerRecord).has(partition(0));
                    assertThat(consumerRecord).has(value("{\"type\":\"IPv6Raw\",\"lease\":{\"ipAddress\":\"99.99.99.1\",\"macAddress\":\"00-00-00-00-00-02\",\"hostname\":\"LOCALHOST\",\"date\":\"1969-12-31\",\"macRelay\":\"A2\",\"leaseId\":2,\"docsisSupport\":\"S2\",\"clientId\":2,\"rebootDate\":\"1969-12-31\",\"orderType\":4444,\"duId\":\"7777\",\"iaId\":\"8888\",\"iaType\":1,\"prefixLength\":\"001\",\"cmtsId\":\"3333\",\"dspId\":2222}}"));
                }

                latch.countDown();
            }
        });

        container = new KafkaMessageListenerContainer<>(cf, containerProps);
        container.setBeanName("sampleConsumer");

        container.start();
//      ContainerTestUtils.waitForAssignment(container, embeddedKafka.getPartitionsPerTopic());

        Map<String, Object> senderProps = KafkaTestUtils.producerProps(embeddedKafka);
        ProducerFactory<Integer, String> pf = new DefaultKafkaProducerFactory<>(senderProps);
        KafkaTemplate<Integer, String> template = new KafkaTemplate<>(pf);
        ObjectMapper mapper = new ObjectMapper();

        IPv4 ipv4 = new IPv4("99.99.99.1", "00-00-00-00-00-01", "LOCALHOST", new Date(0), "A1", 1L, "S1", 1L, "3333", new Date(0), 4444, 2222L);
        IPv6 ipv6 = new IPv6("99.99.99.1", "00-00-00-00-00-02", "LOCALHOST", new Date(0), "A2", 2L, "S2", 2L, "3333", new Date(0), 4444, 2222L, "7777", "8888", 1, "001");

        template.setDefaultTopic(KEY_TOPIC);
        template.sendDefault(0, 0, mapper.writeValueAsString(new KafkaLeaseMessage<>(ipv4.getClass().getSimpleName(), ipv4)));
        template.sendDefault(0, 1, mapper.writeValueAsString(new KafkaLeaseMessage<>(ipv6.getClass().getSimpleName(), ipv6)));
        template.flush();

        //assertThat(latch.await(1, TimeUnit.SECONDS)).isTrue();

    }
}
