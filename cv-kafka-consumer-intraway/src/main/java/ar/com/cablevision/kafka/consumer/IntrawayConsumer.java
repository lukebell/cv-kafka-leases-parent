package ar.com.cablevision.kafka.consumer;

import java.util.concurrent.CountDownLatch;

import ar.com.cablevision.common.exceptions.ProcessException;
import ar.com.cablevision.common.kafka.messages.raw.IPRaw;
import ar.com.cablevision.common.kafka.messages.raw.RawLease;
import ar.com.cablevision.kafka.manager.LeaseManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

public class IntrawayConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntrawayConsumer.class);

    private final CountDownLatch latch = new CountDownLatch(1);

    private final String CONSUMER_TOPICS = "leases";

    private final String LISTENER_ID = "intraway";

    private final String CONSUMER_GROUP_ID = "1";

    @Autowired
    private LeaseManager leaseManager;

    @KafkaListener(id = LISTENER_ID, topics = CONSUMER_TOPICS, group = CONSUMER_GROUP_ID)
    public void onMessage(@Payload(required = false) RawLease<IPRaw> record,
                          @Header(KafkaHeaders.OFFSET) String offset) {
        try {
            leaseManager.processLease(record);
            latch.countDown();
        } catch (Exception e) {
            String message = "[cv-kafka-consumer-intraway] - Process Error: ";
            LOGGER.error(message, e);
            throw new ProcessException(message, e);
        }
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
