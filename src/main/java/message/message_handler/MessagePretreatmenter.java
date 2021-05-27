package message.message_handler;

public class MessagePretreatmenter {
    Map<MessageType, IdentificationStage > messageTypeStageMap;
    Map< IdentificationStage, Set<MessageType>> messageStageSetMap;
    IdentificationStage getMessageStage(Message message){

    }
    Set<MessageType> getMessageSet(IdentificationStage stage){

    }
    bool messageCheck(Message message, List<message> messageList){

    }
    List<Message> messageFilter(Message message, List<message> messageList){
        
    }
}
