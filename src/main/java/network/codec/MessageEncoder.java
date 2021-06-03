package network.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import message.Message;
import util.serialization.MessageJacksonEncoder;

import java.nio.charset.StandardCharsets;

public class MessageEncoder extends MessageToByteEncoder<Message> {

    private String delimiter;

    public MessageEncoder(String delimiter) {
        this.delimiter = delimiter;
    }

    MessageJacksonEncoder encoder = new MessageJacksonEncoder();

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Message message, ByteBuf byteBuf) throws Exception {

        byteBuf.writeBytes(encoder.encode(message));

        byteBuf.writeBytes(delimiter.getBytes(StandardCharsets.UTF_8));

        channelHandlerContext.flush();

    }

}
