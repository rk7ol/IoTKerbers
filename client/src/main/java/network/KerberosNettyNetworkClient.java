package network;

import config.Config;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import message.Message;
import message.request.AuthLoginRequest;
import message.response.AuthKeyResponse;
import message.response.AuthTicketResponse;
import module.Key;
import module.ticket.TicketGrantingTicket;
import network.codec.MessageDecoder;
import network.codec.MessageEncoder;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class KerberosNettyNetworkClient {
    private final Bootstrap bootstrap;
    private final EventLoopGroup workerGroup;
    private final Map<String , Channel> ChannelMap = new HashMap<>();

    public KerberosNettyNetworkClient() {
        this.workerGroup = new NioEventLoopGroup();
        this.bootstrap = new Bootstrap();

        bootstrap.group(workerGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        //in
                        p.addLast(new LengthFieldBasedFrameDecoder(8 * 1024 * 1024,0,4,-4,4));
                        p.addLast(new MessageDecoder());

                        //out
                        p.addLast(new MessageEncoder());

                    }
                });

    }

    Channel connect(String host, int port) throws ExecutionException, InterruptedException {
        CompletableFuture<Channel> completableFuture = new CompletableFuture<>();
        bootstrap.connect(host,port).addListener((ChannelFutureListener) future -> {
            if (future.isSuccess()) {
                completableFuture.complete(future.channel());
            } else {
                throw new IllegalStateException();
            }
        }).sync();
        return completableFuture.get();
    }

    public void SendMessage(Message message) throws ExecutionException, InterruptedException {

        String adr = Config.getAddressByMessageType(message.getType());

        int port = Config.getPortByMessageType(message.getType());

        Channel channel;

        if(ChannelMap.get(adr) == null){
            channel = connect(adr,port);
            ChannelMap.put(adr,channel);
        }else {
            channel = ChannelMap.get(adr);
        }

        if(channel.isActive()){
            channel.writeAndFlush(message);
        }else {
            channel = connect(adr,port);

            SendMessage(message);
        }

    }

    void shutdown() {
        workerGroup.shutdownGracefully();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        KerberosNettyNetworkClient client = new KerberosNettyNetworkClient();
        Message message = new AuthLoginRequest("deswa");
        client.SendMessage(message);

    }
}
