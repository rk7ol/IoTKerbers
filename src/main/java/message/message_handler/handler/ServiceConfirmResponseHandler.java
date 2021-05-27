package message.message_handler.handler;

import message.Message;
import message.response.ServiceConfirmResponse;
import network.MessageSender;

import java.util.Set;

public class ServiceConfirmResponseHandler extends MessageHandler{
    boolean handle(ServiceConfirmResponse serviceConfirmResponse, MessageSender messageSender){
        return false;
    }

    @Override
    boolean handle(Set<Message> messages, MessageSender messageSender) {
        return false;
    }
}
