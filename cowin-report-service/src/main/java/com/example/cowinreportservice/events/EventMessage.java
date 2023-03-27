package com.example.cowinreportservice.events;

import org.springframework.context.ApplicationEvent;

public class EventMessage extends ApplicationEvent {
    private String message;

    public EventMessage(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
