package message.message_handler.handler;

import message.Message;

import java.util.Set;

public class ServiceTicketRequestAndVerifyHandler extends MessageHandler{
    boolean handle(ServiceTicketRequest serviceTicketRequest, ServiceRequestVerifyRequest serviceRequestVerifyRequest, MessageSender messageSender){
        return false;
    }

    @Override
    boolean handle(Set<Message> messages, MessageSender messageSender) {
        return false;
    }
}
