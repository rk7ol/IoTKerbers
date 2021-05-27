package message.message_handler.handler;

import message.Message;
import message.MessageType;
import message.request.AuthLoginRequest;
import message.response.AuthTicketResponse;
import module.Key;
import module.ticket.TicketGrantingTicket;
import network.MessageSender;
import util.Util;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class AuthLoginRequestHandler extends MessageHandler {

    boolean handle(AuthLoginRequest authLoginRequest, MessageSender messageSender){
        if(authLoginRequest.getUsername()!=null){

            Key key = new Key(Util.oneWayHash64(authLoginRequest.getUsername()));
            Key key1=new Key(Util.random64Bits());
            TicketGrantingTicket ticket=new TicketGrantingTicket(key1,authLoginRequest.getUsername(),,System.currentTimeMillis());
            ticket.encrypt(key);
            ticket.encrypt(key);//使用KTGS做为密钥调用TGT的方法encrypt加密TGT；
            AuthTicketResponse authTicketResponse=new AuthTicketResponse(0,ticket);
            AuthTicketResponse authTicketResponse1=new AuthTicketResponse(0,ticket);
            MessageSender.pushMessage(authTicketResponse);
            MessageSender.pushMessage(authTicketResponse1);
            return true;
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
