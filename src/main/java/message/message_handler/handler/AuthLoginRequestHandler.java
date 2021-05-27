package message.message_handler.handler;

import message.Message;
import message.request.AuthLoginRequest;
import network.MessageSender;

import java.util.Set;

public class AuthLoginRequestHandler extends MessageHandler {
    boolean handle(AuthLoginRequest authLoginRequest, MessageSender messageSender){
        return false;
    }
    @Override
    boolean handle(Set<Message> messages, MessageSender messageSender) {
        AuthLoginRequest authLogin = (AuthLoginRequest) messages.iterator().next();

        handle(authLogin, messageSender);

        return false;
    }
}