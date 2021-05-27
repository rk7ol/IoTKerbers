package message.message_handler.handler;

import message.Message;
import message.request.AccessRequestVerifyRequest;
import message.request.AccessTicketRequest;
import message.response.Response;
import network.MessageSender;

import java.util.List;
import java.util.Set;
//服务授权
public class AccessTicketRequestAndVerifyHandler extends MessageHandler{
    boolean handle(AccessTicketRequest accessTicketRequest, AccessRequestVerifyRequest accessRequestVerifyRequest, MessageSender messageSender){

        return false;
    }

    @Override
    public boolean handle(List<Message> messages, MessageSender messageSender) {
        return false;
    }
}
