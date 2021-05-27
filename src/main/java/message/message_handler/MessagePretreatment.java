package message.message_handler;

import message.Message;
import message.MessageType;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MessagePretreatment {
    Map<MessageType, IdentificationStage > messageTypeStageMap;
    Map< IdentificationStage, Set<MessageType>> messageStageSetMap;
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
