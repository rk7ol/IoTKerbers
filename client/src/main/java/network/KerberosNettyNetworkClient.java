package network;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import message.Message;
import network.codec.MessageDecoder;
import network.codec.MessageEncoder;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class KerberosNettyNetworkClient {
    private final Bootstrap bootstrap;
    private final EventLoopGroup workerGroup;




    public KerberosNettyNetworkClient(EventLoopGroup workerGroup) {
        this.workerGroup = new NioEventLoopGroup();
        this.bootstrap = new Bootstrap();
    }

    void initializeClient(){
        bootstrap.group(workerGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE,true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(new MessageEncoder());
                        p.addLast(new MessageDecoder());
                    }
                });
    }

    Channel connect (String host, int port) throws ExecutionException, InterruptedException {
        CompletableFuture<Channel> completableFuture = new CompletableFuture<>();
        bootstrap.connect(host,port).addListener((ChannelFutureListener) future -> {
            if (future.isSuccess()) {
                completableFuture.complete(future.channel());
            } else {
                throw new IllegalStateException();
            }
        });
        return completableFuture.get();
    }

    void messageDeal(ChannelHandlerContext ctx, Object msg) throws InterruptedException {

        while (true){
            Thread.sleep(100);

            Message message = MessageSender.pollMessage();

        }

    }

    void shutdown(){
        workerGroup.shutdownGracefully();
    }
}
