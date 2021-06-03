package message.handler;

import message.Message;
import message.message_handler.handler.MessageHandler;
import message.response.ServiceConfirmResponse;
import module.Timestamp;
import network.MessageSender;

import java.util.List;


public class ServiceConfirmResponseHandler extends MessageHandler {
    boolean handle(ServiceConfirmResponse serviceConfirmResponse, MessageSender messageSender){
        if (serviceConfirmResponse.getCode()==1){
            return false;
        }if (serviceConfirmResponse.getCode()==3){
            return false;
        }if (serviceConfirmResponse.getCode()==0){
            Timestamp t=serviceConfirmResponse.getCtimestamp();
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean handle(List<Message> messages, MessageSender messageSender) {
        return false;
    }
}
