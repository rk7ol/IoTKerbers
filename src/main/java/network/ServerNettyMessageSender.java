package network;
import io.netty.channel.Channel;
import message.Message;


public class ServerNettyMessageSender extends MessageSender{


    Channel channel;

    public ServerNettyMessageSender(Channel channel) {
        this.channel = channel;
    }

    @Override
    boolean sendMessage(Message message) {

        channel.writeAndFlush(message);

        return false;
    }
}
