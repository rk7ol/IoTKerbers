package network;


import message.Message;

import java.util.LinkedList;

public abstract class MessageSender {



    public boolean pushMessage(Message message){
        return sendMessage(message);
    }


    abstract boolean sendMessage(Message message);
}
