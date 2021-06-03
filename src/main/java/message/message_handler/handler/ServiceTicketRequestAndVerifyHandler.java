package message.message_handler.handler;

import message.Message;
import message.request.ServiceRequestVerifyRequest;
import message.request.ServiceTicketRequest;
import message.response.ServiceConfirmResponse;
import network.MessageSender;

import java.util.List;

public class ServiceTicketRequestAndVerifyHandler extends MessageHandler{
    boolean handle(ServiceTicketRequest serviceTicketRequest, ServiceRequestVerifyRequest serviceRequestVerifyRequest, MessageSender messageSender){
        byte[] bytes=serviceTicketRequest.getSST();
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
