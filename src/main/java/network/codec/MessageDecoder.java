package network.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import util.serialization.MessageJacksonDecoder;

import java.util.List;

public class MessageDecoder extends ByteToMessageDecoder {

    MessageJacksonDecoder decoder = new MessageJacksonDecoder();


    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {


        byte[] bytes = new byte[1024];

        byteBuf.readBytes(bytes);

        list.add(decoder.decode(bytes));


    }
}
