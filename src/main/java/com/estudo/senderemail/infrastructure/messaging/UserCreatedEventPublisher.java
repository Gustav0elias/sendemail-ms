package com.estudo.senderemail.infrastructure.messaging;

import com.estudo.senderemail.application.dto.Response.UserResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreatedEventPublisher {

    private final RabbitTemplate rabbitTemplate;
    private static final String EXCHANGE = "user.events";
    private static final String ROUTING_KEY = "user.created";

    public void publishUserCreatedEvent(UserResponse user) {
        try {
            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, user);

        } catch (Exception e) {
            System.err.println("Failed to publish user created event: " + e.getMessage());
        }
    }
} 