package network;
import message.Message;


public class NettyMessageSender extends MessageSender{







    @Override
    boolean sendMessage(Message message) {

        pushMessage(message);

        return false;
    }
}
