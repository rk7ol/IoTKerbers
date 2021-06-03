package network.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import util.serialization.MessageJacksonDecoder;

import java.util.List;

public class MessageDecoder extends DelimiterBasedFrameDecoder {

    MessageJacksonDecoder decoder = new MessageJacksonDecoder();


    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf buffer) throws Exception {


        return decoder.decode(buffer.array());


        //  super.decode(ctx, buffer);
    }

    public MessageDecoder(int maxFrameLength, ByteBuf delimiter) {
        super(maxFrameLength, delimiter);

    }
}
