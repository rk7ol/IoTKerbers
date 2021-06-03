package network.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import message.Message;
import util.serialization.MessageJacksonEncoder;

import java.nio.charset.StandardCharsets;

public class MessageEncoder extends MessageToByteEncoder<Message> {

    MessageJacksonEncoder encoder = new MessageJacksonEncoder();

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Message message, ByteBuf out) throws Exception {

        byte[] bodyBytes = encoder.encode(message);

        out.writeInt(bodyBytes.length);
        out.writeBytes(bodyBytes);

    }
}
