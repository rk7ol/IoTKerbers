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





        messageStageSetMap = new HashMap<>();



        messageStageSetMap.put(IdentificationStage.AUTH_REQUEST, new HashSet<>(Collections.singleton(MessageType.AUTH_LOGIN_REQUEST)));



    }

    IdentificationStage getMessageStage(Message message){

        return null;

    }
    Set<MessageType> getMessageSet(IdentificationStage stage){
        return null;
    }
    boolean messageCheck(Message message, List<Message> messageList){
        return false;
    }
    List<Message> messageFilter(Message message, List<Message> messageList){
        return null;
    }
}
