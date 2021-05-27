package message.message_handler.handler;

import message.Message;
import message.response.AuthTicketResponse;

import java.util.Set;

public class AuthTicketResponseHandler extends MessageHandler{
    boolean handle(AuthTicketResponse authTicketResponse){
        return false;
    }

    @Override
    boolean handle(Set<Message> messages, MessageSender messageSender) {
        return false;
    }
}
