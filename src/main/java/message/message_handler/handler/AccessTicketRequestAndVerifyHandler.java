package message.message_handler.handler;

import message.Message;

import java.util.Set;

public class AccessTicketRequestAndVerifyHandler extends MessageHandler{
    boolean handle(AccessTicketRequest accessTicketRequest, AccessRequestVerifyRequest accessRequestVerifyRequest, MessageSender messageSender){
        return false;
    }

    @Override
    boolean handle(Set<Message> messages, MessageSender messageSender) {
        return false;
    }
}
