package message.message_handler.handler;

import message.Message;
import message.response.AccessTicketResponse;
import network.MessageSender;

import java.util.Set;

public class AccessTicketResponseHandler extends MessageHandler{
    boolean handle(AccessTicketResponse accessTicketResponse){
        return false;
    }

    @Override
    boolean handle(Set<Message> messages, MessageSender messageSender) {
        return false;
    }
}
