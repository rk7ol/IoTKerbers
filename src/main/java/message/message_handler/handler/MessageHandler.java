package message.message_handler.handler;

import message.Message;
import network.MessageSender;

import java.util.Set;


public abstract class MessageHandler {

    abstract boolean handle(Set<Message> messages, MessageSender messageSender);
}
