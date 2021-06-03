package network;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import network.codec.MessageDecoder;
import network.codec.MessageEncoder;

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
                       // p.addLast(new MessageEncoder());
                       // p.addLast(new MessageDecoder());


                        p.addLast(new ChannelInboundHandlerAdapter(){

                            @Override
                            public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                super.channelActive(ctx);

                                ctx.writeAndFlush("Hello from server");
                            }

                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                super.channelRead(ctx, msg);

                                System.out.println("client: " + msg);
                            }
                        });

                    }
                });
    }

    void listen (int port) throws InterruptedException {
        // 绑定端口，同步等待绑定成功
        ChannelFuture f = serverBootstrap.bind(port).sync();
        // 等待服务端监听端口关闭
        f.channel().closeFuture().sync();
    }

    void messageDeal(ChannelHandlerContext ctx, Object msg){

    }

    void shutdown(){
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }

    public static void main(String[] args) throws InterruptedException {

        KerberosNettyNetworkServer server = new KerberosNettyNetworkServer();

        server.initializeServer();

        server.listen(4122);


    }
}
