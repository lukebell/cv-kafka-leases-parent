package ar.com.cablevision.kafka.consumer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.springframework.kafka.test.assertj.KafkaConditions.key;
import static org.springframework.kafka.test.assertj.KafkaConditions.partition;
import static org.springframework.kafka.test.assertj.KafkaConditions.value;

import ar.com.cablevision.common.kafka.messages.enriched.IPv6;
import ar.com.cablevision.common.kafka.messages.enriched.KafkaLeaseMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.Consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.*;

import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.kafka.test.utils.KafkaTestUtils;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class IntrawayConsumerTests {


    private static final String KEY_TOPIC = "enrichedLeases";

    @ClassRule
    public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, false, KEY_TOPIC);

    private static Consumer<Integer, String> consumer;

    @BeforeClass
    public static void setUp() throws Exception {
        ConsumerFactory<Integer, String> cf = new DefaultKafkaConsumerFactory<>(
                KafkaTestUtils.consumerProps("testOut", "true", embeddedKafka));
        consumer = cf.createConsumer();
        embeddedKafka.consumeFromAllEmbeddedTopics(consumer);
    }

    @AfterClass
    public static void tearDown() {
        consumer.close();
    }

    @Autowired
    private IntrawayConsumer listener;

    @Test
    @Ignore
    public void receiveMessages() throws InterruptedException {
        System.out.println(Thread.currentThread().getId());
        assertThat(this.listener.getLatch().await(5, TimeUnit.SECONDS)).isTrue();
    }

    @Test
    public void deserializeIPv4Messages() throws Exception {

        System.out.println(Thread.currentThread().getId());

        Map<String, Object> senderProps = KafkaTestUtils.producerProps(embeddedKafka);
        DefaultKafkaProducerFactory<Integer, String> pf = new DefaultKafkaProducerFactory<>(senderProps);

        KafkaTemplate<Integer, String> template = new KafkaTemplate<>(pf, true);
        template.send(MessageBuilder.withPayload("{\"type\":\"IPv4\", \"lease\": {\"ipAddress\":\"10.8.21.21\", \"macAddress\":\"01:06:50:39:55:6c:c1:95\", \"hostname\":\"SP-Ds6M-Us768K-P2\", \"date\": \"2014-01-01T23:28:56.782Z\", \"macRelay\":\"50:39:55:6c:c1:95\", \"leaseId\":4163422471, \"docsisSupport\":\"3.0\", \"clientId\":1044412, \"cmtsId\":\"679\", \"rebootDate\":\"2014-01-01T23:28:56.782Z\", \"requestType\":null, \"dspId\":null}}")
                .setHeader(KafkaHeaders.TOPIC, KEY_TOPIC)
                .setHeader(KafkaHeaders.PARTITION_ID, 0)
                .setHeader(KafkaHeaders.MESSAGE_KEY, 2)
                .build());

        ObjectMapper om = new ObjectMapper();
        ConsumerRecord<Integer, String> record = KafkaTestUtils.getSingleRecord(consumer, KEY_TOPIC);
        KafkaLeaseMessage message = om.readValue(record.value(), KafkaLeaseMessage.class);

        assertThat(record).has(key(2));
        assertThat(record).has(partition(0));
        assertThat(record).has(value("{\"type\":\"IPv4\", \"lease\": {\"ipAddress\":\"10.8.21.21\", \"macAddress\":\"01:06:50:39:55:6c:c1:95\", \"hostname\":\"SP-Ds6M-Us768K-P2\", \"date\": \"2014-01-01T23:28:56.782Z\", \"macRelay\":\"50:39:55:6c:c1:95\", \"leaseId\":4163422471, \"docsisSupport\":\"3.0\", \"clientId\":1044412, \"cmtsId\":\"679\", \"rebootDate\":\"2014-01-01T23:28:56.782Z\", \"requestType\":null, \"dspId\":null}}"));
        assertThat(message.getType().equals("IPv4"));
        assertThat(message.getLease().getLeaseId() == 4163422471L);
    }

    @Test
    public void deserializeIPv6Messages() throws Exception {

        System.out.println(Thread.currentThread().getId());

        Map<String, Object> senderProps = KafkaTestUtils.producerProps(embeddedKafka);
        DefaultKafkaProducerFactory<Integer, String> pf = new DefaultKafkaProducerFactory<>(senderProps);

        KafkaTemplate<Integer, String> template = new KafkaTemplate<>(pf, true);
        template.send(MessageBuilder.withPayload("{\"type\":\"IPv6\", \"lease\": {\"ipAddress\":\"10.8.21.21\", \"macAddress\":\"01:06:50:39:55:6c:c1:95\", \"hostname\":\"SP-Ds6M-Us768K-P2\", \"date\": \"2014-01-01T23:28:56.782Z\", \"macRelay\":\"50:39:55:6c:c1:95\", \"leaseId\":4163422472, \"docsisSupport\":\"3.0\", \"clientId\":1044412, \"cmtsId\":\"679\", \"rebootDate\":\"2014-01-01T23:28:56.782Z\", \"requestType\":null, \"dspId\":null, \"duId\":\"7777\"}}")
                .setHeader(KafkaHeaders.TOPIC, KEY_TOPIC)
                .setHeader(KafkaHeaders.PARTITION_ID, 0)
                .setHeader(KafkaHeaders.MESSAGE_KEY, 2)
                .build());

        ObjectMapper om = new ObjectMapper();
        ConsumerRecord<Integer, String> record = KafkaTestUtils.getSingleRecord(consumer, KEY_TOPIC);
        KafkaLeaseMessage message = om.readValue(record.value(), KafkaLeaseMessage.class);

        assertThat(record).has(key(2));
        assertThat(record).has(partition(0));
        assertThat(record).has(value("{\"type\":\"IPv6\", \"lease\": {\"ipAddress\":\"10.8.21.21\", \"macAddress\":\"01:06:50:39:55:6c:c1:95\", \"hostname\":\"SP-Ds6M-Us768K-P2\", \"date\": \"2014-01-01T23:28:56.782Z\", \"macRelay\":\"50:39:55:6c:c1:95\", \"leaseId\":4163422472, \"docsisSupport\":\"3.0\", \"clientId\":1044412, \"cmtsId\":\"679\", \"rebootDate\":\"2014-01-01T23:28:56.782Z\", \"requestType\":null, \"dspId\":null, \"duId\":\"7777\"}}"));
        assertThat(message.getType()).isEqualTo("IPv6");
        assertThat(message.getLease().getLeaseId()).isEqualTo(4163422472L);
        assertThat(((IPv6)message.getLease()).getDuId()).isEqualTo("7777");
    }
}