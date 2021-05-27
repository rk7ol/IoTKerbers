package message.message_handler.handler;

import message.Message;
import message.response.AuthKeyResponse;

import java.util.Set;

public class AuthKeyResponseHandler extends MessageHandler{
    boolean handle(AuthKeyResponse authKeyResponse){
        return false;
    }

    @Override
    boolean handle(Set<Message> messages, MessageSender messageSender) {
        return false;
    }
}
