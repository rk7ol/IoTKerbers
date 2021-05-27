package network;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class KerberosNettyNetworkClient {
    private final Bootstrap bootstrap;

    public KerberosNettyNetworkClient() {
        this.bootstrap = new Bootstrap();
    }

    void initializeClient(){
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        bootstrap.group(workerGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE,true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast();
                    }
                });

    }

    void connect (String host, int port){

    }

    void messageDeal(ChannelHandlerContext ctx, Object msg){

    }

    void shutdown(){

    }
}
