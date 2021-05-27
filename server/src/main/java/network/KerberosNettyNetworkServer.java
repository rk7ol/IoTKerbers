package network;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class KerberosNettyNetworkServer {
    private final ServerBootstrap serverBootstrap;
    private final EventLoopGroup workerGroup;
    private final EventLoopGroup bossGroup;

    public KerberosNettyNetworkServer() {
        this.serverBootstrap = new ServerBootstrap();
        this.workerGroup = new NioEventLoopGroup();
        this.bossGroup = new NioEventLoopGroup(1);
    }

    void initializeServer(){
        serverBootstrap.group(bossGroup,workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE,true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast();
                    }
                });
    }

    void listen (int port){
        serverBootstrap.bind(port);
    }

    void messageDeal(ChannelHandlerContext ctx, Object msg){

    }

    void shutdown(){
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }
}
