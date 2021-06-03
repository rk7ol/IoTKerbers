package message.handler;

import config.Config;
import message.Message;
import message.message_handler.handler.MessageHandler;
import message.request.AuthLoginRequest;
import message.response.AuthKeyResponse;
import message.response.AuthTicketResponse;
import module.Key;
import module.ticket.TicketGrantingTicket;
import network.MessageSender;
import network.NettyMessageSender;
import util.Util;

import java.util.List;

public class AuthLoginRequestHandler extends MessageHandler {

    boolean handle(AuthLoginRequest authLoginRequest, MessageSender messageSender) {
        if (authLoginRequest.getUsername() != null) {
            Key userSecretKey = new Key(Util.oneWayHash64(authLoginRequest.getUsername()));
            Key TGSSessionKey = new Key(Util.random64Bits());
            TGSSessionKey.encrypt(userSecretKey);


            TicketGrantingTicket TGT = new TicketGrantingTicket(TGSSessionKey, authLoginRequest.getUsername(), null, System.currentTimeMillis());
            TGT.encrypt(Config.config.getTicketGrantingServerKey());//使用KTGS做为密钥调用TGT的方法encrypt加密TGT；


            AuthKeyResponse authKeyResponse = new AuthKeyResponse(0, userSecretKey);

            AuthTicketResponse authTicketResponse = new AuthTicketResponse(0, TGT);

            MessageSender.pushMessage(authKeyResponse);
            MessageSender.pushMessage(authTicketResponse);

            return true;
        } else {
            System.out.println("username null");
            AuthTicketResponse authTicketResponse = new AuthTicketResponse(1, null);
            MessageSender.pushMessage(authTicketResponse);
            return true;
        }
    }

    @Override
    public boolean handle(List<Message> messages, MessageSender messageSender) {
        AuthLoginRequest authLogin = (AuthLoginRequest) messages.iterator().next();
        //handle(authLogin, messageSender);

        return false;
    }

    public static void main(String[] args) {
        AuthLoginRequestHandler authLoginRequestHandler = new AuthLoginRequestHandler();

        AuthLoginRequest authLoginRequest = new AuthLoginRequest(null);
        MessageSender sender = new NettyMessageSender();

        authLoginRequestHandler.handle(authLoginRequest, sender);

    }


}