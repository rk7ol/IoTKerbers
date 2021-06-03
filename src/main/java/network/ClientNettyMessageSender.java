package network;

import message.Message;
import network.MessageSender;

import java.util.LinkedList;

public class ClientNettyMessageSender extends MessageSender {

    private static LinkedList<Message> MESSAGE_SEND_QUEUE = new LinkedList<>();


    public static Message pollMessage(){
        return MESSAGE_SEND_QUEUE.poll();
    }


    @Override
    boolean sendMessage(Message message) {
        MESSAGE_SEND_QUEUE.push(message);
        return true;
    }
}
