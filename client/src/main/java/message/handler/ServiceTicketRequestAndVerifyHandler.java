package message.handler;

import config.Config;
import message.Message;
import message.message_handler.handler.MessageHandler;
import message.request.ServiceRequestVerifyRequest;
import message.request.ServiceTicketRequest;
import message.response.ServiceConfirmResponse;
import module.ticket.ServiceServerTicket;
import network.MessageSender;

import java.util.List;

public class ServiceTicketRequestAndVerifyHandler extends MessageHandler {
    boolean handle(ServiceTicketRequest serviceTicketRequest, ServiceRequestVerifyRequest serviceRequestVerifyRequest, MessageSender messageSender){
        byte[] bytes=serviceTicketRequest.getSST();
        Config.config.getServiceServerTicket();
        
        serviceRequestVerifyRequest.getRequest_info();
        ServiceConfirmResponse serviceConfirmResponse=new ServiceConfirmResponse(3,bytes);
        MessageSender.pushMessage(serviceConfirmResponse);

        return false;
    }

    @Override
    public boolean handle(List<Message> messages, MessageSender messageSender) {
        return false;
    }
}
