package message.message_handler.handler;

import message.Message;
import message.response.AccessKeyResponse;
import message.response.AccessTicketResponse;
import network.MessageSender;

import java.util.Set;

public class AccessKeyResponseHandler extends MessageHandler{
    boolean handle(AccessKeyResponse accessKeyResponse , AccessTicketResponse accessTicketResponse,MessageSender messageSender){
        return false;
    }

    @Override
    boolean handle(Set<Message> messages, MessageSender messageSender) {
        return false;
    }
}
