package network;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import org.apache.logging.log4j.message.Message;

import java.util.LinkedList;


public class NettyMessageSender extends MessageSender{







    @Override
    boolean sendMessage(Message message) {

        pushMessage(message);

        return false;
    }
}
