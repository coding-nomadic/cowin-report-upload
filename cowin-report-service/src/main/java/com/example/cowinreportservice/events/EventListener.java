package com.example.cowinreportservice.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventListener implements ApplicationListener<EventMessage> {
    @Override
    public void onApplicationEvent(EventMessage event) {
        log.info("Received event message - {}", event.getMessage());
    }
}
