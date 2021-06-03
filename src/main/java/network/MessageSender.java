package network;


import message.Message;

import java.util.LinkedList;

public abstract class MessageSender {



    public boolean pushMessage(Message message){
        return sendMessage(message);
    }


    public abstract byte[] getRemoteAddress();


    abstract boolean sendMessage(Message message);
}
