package message.message_handler.handler;

import message.Message;
import message.request.AccessRequestVerifyRequest;
import message.request.AccessTicketRequest;
import network.MessageSender;

import java.util.List;
import java.util.Set;

public class AccessTicketRequestAndVerifyHandler extends MessageHandler{
    boolean handle(AccessTicketRequest accessTicketRequest, AccessRequestVerifyRequest accessRequestVerifyRequest, MessageSender messageSender){
        return false;
    }

    @Override
    public boolean handle(List<Message> messages, MessageSender messageSender) {
        return false;
    }
}
