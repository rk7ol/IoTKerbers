package message.message_handler.handler;

import message.Message;
import network.MessageSender;

import java.util.List;
import java.util.Set;


public abstract class MessageHandler {

    public abstract boolean handle(List<Message> messages, MessageSender messageSender);
}
