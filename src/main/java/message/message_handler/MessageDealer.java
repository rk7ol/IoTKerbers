package message.message_handler;

import message.Message;
import message.MessageType;
import message.message_handler.handler.*;
import network.MessageSender;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MessageDealer {
    public static final Map<MessageType, MessageHandler> messageTypeHandlerMap;

    public static final LinkedList<Message> RECEIVE_MESSAGE_LIST;

    public static Message getFirstMessage(){
        return RECEIVE_MESSAGE_LIST.getFirst();
    }

    static {
        RECEIVE_MESSAGE_LIST = new LinkedList<>();


        messageTypeHandlerMap = new HashMap<>();
        //消息对应的处理器


        //AUTH
        messageTypeHandlerMap.put(MessageType.AUTH_LOGIN_REQUEST, new AuthLoginRequestHandler());
        MessageHandler handler = new AuthKeyResponseHandler();
        messageTypeHandlerMap.put(MessageType.AUTH_TICKET_RESPONSE, handler);
        messageTypeHandlerMap.put(MessageType.AUTH_KEY_RESPONSE, handler);
        handler = new AccessKeyResponseHandler();

        //ACCESS
        messageTypeHandlerMap.put(MessageType.ACCESS_KEY_RESPONSE, handler);
        messageTypeHandlerMap.put(MessageType.ACCESS_TICKET_RESPONSE, handler);
        handler = new AccessTicketRequestAndVerifyHandler();
        messageTypeHandlerMap.put(MessageType.ACCESS_TICKET_REQUEST, handler);
        messageTypeHandlerMap.put(MessageType.ACCESS_REQUEST_VERIFY_REQUEST, handler);

        //SERVICE
        handler = new ServiceTicketRequestAndVerifyHandler();
        messageTypeHandlerMap.put(MessageType.SERVICE_TICKET_REQUEST, handler);
        messageTypeHandlerMap.put(MessageType.SERVICE_REQUEST_VERIFY_REQUEST, handler);
        messageTypeHandlerMap.put(MessageType.SERVICE_CONFIRM_RESPONSE, new ServiceConfirmResponseHandler());
    }

    //消息处理
    //获取消息对应的handler
    MessageHandler getMessageHandler(Message message){
        return messageTypeHandlerMap.get(message.getType());
    }

    //对指定的消息进行相应的处理
    boolean messageDeal(List<Message> messageList, MessageSender messageSender){
         Message message = MessageDealer.getFirstMessage();//获取第一个message
         MessageHandler handler = getMessageHandler(message);
         return handler.handle(messageList, messageSender);//返回bool
    }
}
