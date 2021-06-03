package network.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import message.Message;
import util.serialization.MessageJacksonDecoder;

import java.util.List;

public class MessageDecoder extends ByteToMessageDecoder {

    MessageJacksonDecoder decoder = new MessageJacksonDecoder();


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        byte[] bytes = new byte[in.readableBytes()];

        in.readBytes(bytes);

        System.out.println(new String(bytes));

        Object obj = decoder.decode(bytes);

        out.add(obj);

    }
}
