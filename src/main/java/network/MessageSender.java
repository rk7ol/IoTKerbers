package network;


import message.Message;

import java.util.LinkedList;

public abstract class MessageSender {

    protected static LinkedList<Message> MESSAGE_SEND_QUEUE = new LinkedList<>();

    public static Message pollMessage(){
        return MESSAGE_SEND_QUEUE.poll();
    }

    public static boolean pushMessage(Message message){
        return MESSAGE_SEND_QUEUE.add(message);
    }


    public abstract byte[] getRemoteAddress();


    abstract boolean sendMessage(Message message);
}
