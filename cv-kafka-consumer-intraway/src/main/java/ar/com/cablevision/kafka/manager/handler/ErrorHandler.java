package ar.com.cablevision.kafka.manager.handler;

import ar.com.cablevision.common.exceptions.ProcessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.event.ListenerContainerIdleEvent;
import org.springframework.kafka.support.LoggingProducerListener;
import org.springframework.stereotype.Component;

/**
 * Kafka error handler
 */
@Component
public class ErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);

    @EventListener
    public void idleEventHandler(ListenerContainerIdleEvent event) {
        String message = "[cv-kafka-consumer-intraway] - Max Idle time reached.";
        LOGGER.error(message);
        throw new ProcessException(message);
    }

    @EventListener
    public void producerEventHandler(LoggingProducerListener event){
        String message = "[cv-kafka-consumer-intraway] - Error processing message:";
        LOGGER.error(message, event);
        throw new ProcessException(message);
    }
}
