package network.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import message.Message;
import util.serialization.MessageJacksonEncoder;

public class MessageEncoder extends MessageToByteEncoder<Message> {


    MessageJacksonEncoder encoder = new MessageJacksonEncoder();

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Message message, ByteBuf byteBuf) throws Exception {

        byteBuf.writeBytes(encoder.encode(message));

    }

}
