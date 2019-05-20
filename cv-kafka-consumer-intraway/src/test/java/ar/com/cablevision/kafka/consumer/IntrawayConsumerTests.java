package ar.com.cablevision.kafka.consumer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.springframework.kafka.test.assertj.KafkaConditions.key;
import static org.springframework.kafka.test.assertj.KafkaConditions.partition;
import static org.springframework.kafka.test.assertj.KafkaConditions.value;

import ar.com.cablevision.common.kafka.messages.raw.IPv6Raw;
import ar.com.cablevision.common.kafka.messages.raw.RawLease;
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


    private static final String KEY_TOPIC = "leases";

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
        assertThat(this.listener.getLatch().await(1, TimeUnit.SECONDS)).isTrue();
    }

    @Test
    public void deserializeIPv4Messages() throws Exception {

            System.out.println(Thread.currentThread().getId());

            Map<String, Object> senderProps = KafkaTestUtils.producerProps(embeddedKafka);
            DefaultKafkaProducerFactory<Integer, String> pf = new DefaultKafkaProducerFactory<>(senderProps);

            KafkaTemplate<Integer, String> template = new KafkaTemplate<>(pf, true);
            template.send(MessageBuilder.withPayload("{\"table\":\"CV.EXP_CM_LEASES_IPV4\",\"op_type\":\"I\",\"op_ts\":\"2016-12-07 17:18:51.644987\",\"current_ts\":\"2016-12-07T14:18:56.441000\",\"pos\":\"00000054300006918591\",\"after\":{\"IPADDRESS\":\"200.126.216.11\",\"MACADDRESS\":\"01:06:00:0f:3d:4e:dc:35\",\"HOSTNAME\":\"FIBERTEL\",\"FECHA\":\"2016-12-07:14:18:34\",\"MACRELAY\":\"00:1a:de:90:b1:62\",\"IDLEASE\":\"3953581318\",\"DOCSIS_SUPPORT\":\"PC\",\"IDCLIENTE\":\"433030\",\"IDCMTS\":\"318\",\"FECHA_REBOOT\":null,\"TIPO_PEDIDO\":\"8\",\"IDDSP\":null,\"SRC\":\"1_SERV\",\"IDLEASEIW\":\"3004330917\"}})}")
                    .setHeader(KafkaHeaders.TOPIC, KEY_TOPIC)
                    .setHeader(KafkaHeaders.PARTITION_ID, 0)
                    .setHeader(KafkaHeaders.MESSAGE_KEY, 2)
                    .build());

            ObjectMapper om = new ObjectMapper();
            ConsumerRecord<Integer, String> record = KafkaTestUtils.getSingleRecord(consumer, KEY_TOPIC);
            RawLease message = om.readValue(record.value(), RawLease.class);

            assertThat(record).has(key(2));
            assertThat(record).has(partition(0));
            assertThat(record).has(value("{\"table\":\"CV.EXP_CM_LEASES_IPV4\",\"op_type\":\"I\",\"op_ts\":\"2016-12-07 17:18:51.644987\",\"current_ts\":\"2016-12-07T14:18:56.441000\",\"pos\":\"00000054300006918591\",\"after\":{\"IPADDRESS\":\"200.126.216.11\",\"MACADDRESS\":\"01:06:00:0f:3d:4e:dc:35\",\"HOSTNAME\":\"FIBERTEL\",\"FECHA\":\"2016-12-07:14:18:34\",\"MACRELAY\":\"00:1a:de:90:b1:62\",\"IDLEASE\":\"3953581318\",\"DOCSIS_SUPPORT\":\"PC\",\"IDCLIENTE\":\"433030\",\"IDCMTS\":\"318\",\"FECHA_REBOOT\":null,\"TIPO_PEDIDO\":\"8\",\"IDDSP\":null,\"SRC\":\"1_SERV\",\"IDLEASEIW\":\"3004330917\"}})}"));
            assertThat(message.getTable()).isEqualTo("CV.EXP_CM_LEASES_IPV4");
            assertThat(message.getAfter().getIdCliente()).isEqualTo(433030L);
            assertThat(message.getAfter().getHostname()).isEqualTo("FIBERTEL");

    }

    @Test
    public void deserializeIPv6Messages() throws Exception {

            System.out.println(Thread.currentThread().getId());

            Map<String, Object> senderProps = KafkaTestUtils.producerProps(embeddedKafka);
            DefaultKafkaProducerFactory<Integer, String> pf = new DefaultKafkaProducerFactory<>(senderProps);

            KafkaTemplate<Integer, String> template = new KafkaTemplate<>(pf, true);
            template.send(MessageBuilder.withPayload("{\"table\":\"CV.EXP_CPE_LEASES_IPV6\",\"op_type\":\"I\",\"op_ts\":\"2017-01-20 21:25:36.111840\",\"current_ts\":\"2017-01-20T18:25:41.398000\",\"pos\":\"00000095590015289715\",\"after\":{\"IPADDRESS\":\"53169789249948759751969825344352613001\",\"MACADDRESS\":null,\"DUID\":\"00030001bcc8100f5f1c\",\"IAID\":\"100f5f1c\",\"IATYPE\":\"3\",\"HOSTNAME\":\"FIBERTEL\",\"FECHA\":\"2017-01-20:18:25:22\",\"MACRELAY\":\"bc:c8:10:0f:5f:19\",\"IDLEASE\":\"6564154\",\"DOCSIS_SUPPORT\":\"PC\",\"IDCLIENTE\":\"7131492\",\"IDCMTS\":\"201\",\"FECHA_REBOOT\":null,\"TIPO_PEDIDO\":\"8\",\"IDDSP\":null,\"SRC\":\"1_SERV\",\"IDLEASEIW\":\"65551\",\"PREFIX_LENGTH\":null}}")
                    .setHeader(KafkaHeaders.TOPIC, KEY_TOPIC)
                    .setHeader(KafkaHeaders.PARTITION_ID, 1)
                    .setHeader(KafkaHeaders.MESSAGE_KEY, 3)
                    .build());

            ObjectMapper om = new ObjectMapper();
            ConsumerRecord<Integer, String> record = KafkaTestUtils.getSingleRecord(consumer, KEY_TOPIC);
            RawLease message = om.readValue(record.value(), RawLease.class);

            assertThat(record).has(key(3));
            assertThat(record).has(partition(1));
            assertThat(record).has(value("{\"table\":\"CV.EXP_CPE_LEASES_IPV6\",\"op_type\":\"I\",\"op_ts\":\"2017-01-20 21:25:36.111840\",\"current_ts\":\"2017-01-20T18:25:41.398000\",\"pos\":\"00000095590015289715\",\"after\":{\"IPADDRESS\":\"53169789249948759751969825344352613001\",\"MACADDRESS\":null,\"DUID\":\"00030001bcc8100f5f1c\",\"IAID\":\"100f5f1c\",\"IATYPE\":\"3\",\"HOSTNAME\":\"FIBERTEL\",\"FECHA\":\"2017-01-20:18:25:22\",\"MACRELAY\":\"bc:c8:10:0f:5f:19\",\"IDLEASE\":\"6564154\",\"DOCSIS_SUPPORT\":\"PC\",\"IDCLIENTE\":\"7131492\",\"IDCMTS\":\"201\",\"FECHA_REBOOT\":null,\"TIPO_PEDIDO\":\"8\",\"IDDSP\":null,\"SRC\":\"1_SERV\",\"IDLEASEIW\":\"65551\",\"PREFIX_LENGTH\":null}}"));
            assertThat(message.getTable()).isEqualTo("CV.EXP_CPE_LEASES_IPV6");
            assertThat(((IPv6Raw) message.getAfter()).getDuId()).isEqualTo("00030001bcc8100f5f1c");
            assertThat(((IPv6Raw) message.getAfter()).getIaId()).isEqualTo("100f5f1c");

    }
}