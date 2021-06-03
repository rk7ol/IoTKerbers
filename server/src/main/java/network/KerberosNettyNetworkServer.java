package network;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import message.Message;
import network.codec.MessageDecoder;
import network.codec.MessageEncoder;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class KerberosNettyNetworkServer {
    private final ServerBootstrap serverBootstrap;
    private final EventLoopGroup workerGroup;
    private final EventLoopGroup bossGroup;

    public KerberosNettyNetworkServer() {
        this.serverBootstrap = new ServerBootstrap();
        this.workerGroup = new NioEventLoopGroup();
        this.bossGroup = new NioEventLoopGroup(1);
    }




    void initializeServer() {
        String d = "\t";
        ByteBuf delimiter = Unpooled.wrappedBuffer(d.getBytes(StandardCharsets.UTF_8));
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();

                        //out
                        p.addLast(new MessageEncoder());




                        //in
                        p.addLast(new LengthFieldBasedFrameDecoder(8 * 1024 * 1024,0,4,0,4));
                        p.addLast(new MessageDecoder());

                        p.addLast(new SimpleChannelInboundHandler() {

                            @Override
                            protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
                                Message message = (Message) o;
                                System.out.println("message: " + message);






                            }
                        });
                    }
                });
    }

    void listen(int port) throws InterruptedException {
        // 绑定端口，同步等待绑定成功
        ChannelFuture f = serverBootstrap.bind(port).sync();


        // 等待服务端监听端口关闭
        // f.channel().closeFuture().sync();
    }

    void messageDeal(ChannelHandlerContext ctx, Object msg) {

    }

    void shutdown() {
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }

    public static void main(String[] args) throws InterruptedException {

        KerberosNettyNetworkServer server = new KerberosNettyNetworkServer();

        server.initializeServer();

        server.listen(12000);




    }
}
