package message.message_handler.handler;

import message.Message;
import message.MessageType;
import message.request.AuthLoginRequest;
import message.response.AuthTicketResponse;
import module.Key;
import module.ticket.TicketGrantingTicket;
import network.MessageSender;
import util.Util;

import java.util.List;
import java.util.Set;

public class AuthLoginRequestHandler extends MessageHandler {

    boolean handle(AuthLoginRequest authLoginRequest, MessageSender messageSender){
        if(authLoginRequest.getUsername()!=null){

            Key key = new Key(Util.oneWayHash64(authLoginRequest.getUsername()));
            Key key1=new Key(Util.random64Bits());
            TicketGrantingTicket ticket=new TicketGrantingTicket(,authLoginRequest.getUsername(),authLoginRequest)
        }else {
            AuthTicketResponse authTicketResponse=new AuthTicketResponse(1,null);
            MessageSender.pushMessage(authTicketResponse);
            return true;
        }
    }
    @Override
    public boolean handle(List<Message> messages, MessageSender messageSender) {
        AuthLoginRequest authLogin = (AuthLoginRequest) messages.iterator().next();
        handle(authLogin, messageSender);

        return false;
    }
}
