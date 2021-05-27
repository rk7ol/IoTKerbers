package network;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import org.apache.logging.log4j.message.Message;


public class NettyMessageSender extends MessageSender{







    @Override
    boolean sendMessage(Message message) {

        pushMessage(message);

        return false;
    }
}
