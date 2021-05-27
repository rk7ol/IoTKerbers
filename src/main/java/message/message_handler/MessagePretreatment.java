package message.message_handler;

import message.Message;
import message.MessageType;

import java.util.*;

public class MessagePretreatment {

    public static final Map<MessageType, IdentificationStage > messageTypeStageMap;


    public static final Map< IdentificationStage, Set<MessageType>> messageStageSetMap;

    static {

        messageTypeStageMap = new HashMap<>();
        messageTypeStageMap.put(MessageType.AUTH_LOGIN_REQUEST, IdentificationStage.AUTH_REQUEST);
        messageTypeStageMap.put(MessageType.ACCESS_TICKET_REQUEST,IdentificationStage.ACCESS_REQUEST);
        messageTypeStageMap.put(MessageType.ACCESS_REQUEST_VERIFY_REQUEST,IdentificationStage.ACCESS_REQUEST);
        messageTypeStageMap.put(MessageType.SERVICE_TICKET_REQUEST,IdentificationStage.SERVICE_REQUEST);
        messageTypeStageMap.put(MessageType.SERVICE_REQUEST_VERIFY_REQUEST,IdentificationStage.SERVICE_REQUEST);
        messageTypeStageMap.put(MessageType.ACCESS_KEY_RESPONSE,IdentificationStage.ACCESS_RESPONSE);
        messageTypeStageMap.put(MessageType.AUTH_KEY_RESPONSE,IdentificationStage.AUTH_RESPONSE);
        messageTypeStageMap.put(MessageType.ACCESS_TICKET_RESPONSE,IdentificationStage.ACCESS_RESPONSE);
        messageTypeStageMap.put(MessageType.AUTH_TICKET_RESPONSE,IdentificationStage.AUTH_RESPONSE);
        messageTypeStageMap.put(MessageType.SERVICE_CONFIRM_RESPONSE,IdentificationStage.SERVICE_RESPONSE);

        messageStageSetMap = new HashMap<>();

        HashSet<MessageType> messageTypes = new HashSet<>();
        messageTypes.add(MessageType.AUTH_LOGIN_REQUEST);
        messageStageSetMap.put(IdentificationStage.AUTH_REQUEST, messageTypes);

        messageTypes = new HashSet<>();
        messageTypes.add(MessageType.AUTH_KEY_RESPONSE);
        messageTypes.add(MessageType.AUTH_TICKET_RESPONSE);
        messageStageSetMap.put(IdentificationStage.AUTH_RESPONSE, messageTypes);

        messageTypes=new HashSet<>();
        messageTypes.add(MessageType.ACCESS_TICKET_REQUEST);
        messageTypes.add(MessageType.ACCESS_REQUEST_VERIFY_REQUEST);
        messageStageSetMap.put(IdentificationStage.ACCESS_REQUEST,messageTypes);

        messageTypes=new HashSet<>();
        messageTypes.add(MessageType.ACCESS_TICKET_RESPONSE);
        messageTypes.add(MessageType.ACCESS_KEY_RESPONSE);
        messageStageSetMap.put(IdentificationStage.ACCESS_RESPONSE,messageTypes);

        messageTypes=new HashSet<>();
        messageTypes.add(MessageType.SERVICE_TICKET_REQUEST);
        messageTypes.add(MessageType.SERVICE_REQUEST_VERIFY_REQUEST);
        messageStageSetMap.put(IdentificationStage.SERVICE_REQUEST,messageTypes);

        messageTypes=new HashSet<>();
        messageTypes.add(MessageType.SERVICE_CONFIRM_RESPONSE);
        messageStageSetMap.put(IdentificationStage.SERVICE_RESPONSE,messageTypes);










    }

    //获取消息所处识别阶段
    IdentificationStage getMessageStage(Message message){
        return messageTypeStageMap.get(message.getType());
    }

    Set<MessageType> getMessageSet(IdentificationStage stage){
        return messageStageSetMap.get(stage);
    }
    boolean messageCheck(Message message, List<Message> messageList){
        return false;
    }
    List<Message> messageFilter(Message message, List<Message> messageList){
        return null;
    }
}
