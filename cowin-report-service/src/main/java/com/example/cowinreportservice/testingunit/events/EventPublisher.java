package com.example.cowinreportservice.testingunit.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishEvent(final String message) {
        log.info("Publishing event message !");
        EventMessage customSpringEvent = new EventMessage(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }
}
