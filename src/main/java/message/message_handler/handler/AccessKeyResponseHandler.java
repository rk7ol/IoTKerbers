package message.message_handler.handler;

import message.Message;
import network.MessageSender;

import java.util.Set;

public class AccessKeyResponseHandler extends MessageHandler{
    boolean handle(AccessKeyResponse accessKeyResponse){
        return false;
    }

    @Override
    boolean handle(Set<Message> messages, MessageSender messageSender) {
        return false;
    }
}
