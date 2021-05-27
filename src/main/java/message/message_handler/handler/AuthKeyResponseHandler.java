package message.message_handler.handler;

import message.Message;
import message.response.AuthKeyResponse;
import message.response.AuthTicketResponse;
import network.MessageSender;

import java.util.List;
import java.util.Set;

public class AuthKeyResponseHandler extends MessageHandler{
    boolean handle(AuthKeyResponse authKeyResponse, AuthTicketResponse authTicketResponse, MessageSender sender){
        return false;
    }

    @Override
    public boolean handle(List<Message> messages, MessageSender messageSender) {
        return false;
    }
}
