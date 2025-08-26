package com.websockets.websockets;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration

// Aktiverar WebSocket-meddelandebroker-stöd i Spring min växelstation
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {

    // Här registreras en "endpoint" som klienterna kommer att ansluta till
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // "/websocket" är URL:en som klienten ansluter till
        // setAllowedOriginPatterns("*") tillåter anslutningar från alla domäner (CORS)
        // withSockJS() gör att det fungerar även i webbläsare som inte stödjer native WebSocket
        registry.addEndpoint("/websocket")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }

    // Här konfigurerassjälva meddelandebrokern
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Aktiverar en enkel, intern broker som hanterar meddelanden till klienter
        // Alla meddelanden som skickas till destinations som börjar med "/topic" går via denna broker
        config.enableSimpleBroker("/topic");

        // Alla meddelanden som skickas från klienter till "/app" kommer till @MessageMapping-metoder
        config.setApplicationDestinationPrefixes("/app");
    }
}
