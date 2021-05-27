package message.message_handler;

import message.Message;
import message.MessageType;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MessagePretreatmenter {
    Map<MessageType, IdentificationStage > messageTypeStageMap;
    Map< IdentificationStage, Set<MessageType>> messageStageSetMap;
    IdentificationStage getMessageStage(Message message){

    }
    Set<MessageType> getMessageSet(IdentificationStage stage){

    }
    boolean messageCheck(Message message, List<message> messageList){
        return false;
    }
    List<Message> messageFilter(Message message, List<message> messageList){

    }
}
