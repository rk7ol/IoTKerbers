package message.message_handler;

import message.Message;
import message.MessageType;
import message.message_handler.handler.MessageHandler;
import network.MessageSender;

import java.util.List;
import java.util.Map;

public class MessageDealer {
    Map<MessageType, MessageHandler> messageTypeHandlerMap;
    MessageHandler getMessageHandler(Message message){

        return null;
    }
    boolean messageDeal(List<Message> messageList, MessageSender messageSender){
        return false;
    }
}
