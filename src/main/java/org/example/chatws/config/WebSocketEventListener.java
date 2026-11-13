package org.example.chatws.config;

import org.example.chatws.entity.ChatMessage;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Map;

/** Avisa al canal público cuando un usuario se desconecta. */
@Component
public class WebSocketEventListener {

    private final SimpMessageSendingOperations messagingTemplate;

    public WebSocketEventListener(SimpMessageSendingOperations messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @EventListener
    public void handleDisconnect(SessionDisconnectEvent event) {
        Map<String, Object> attrs = StompHeaderAccessor.wrap(event.getMessage()).getSessionAttributes();
        if (attrs == null) {
            return;
        }
        Object username = attrs.get("username");
        if (username != null) {
            messagingTemplate.convertAndSend("/topic/public",
                    new ChatMessage(username.toString(), null, "LEAVE"));
        }
    }
}
