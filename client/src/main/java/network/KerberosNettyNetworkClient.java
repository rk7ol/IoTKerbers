package network;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.logging.log4j.message.Message;

import java.util.LinkedList;

import network.MessageSender;

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
                        p.addLast();
                    }
                });
    }

    void connect (String host, int port){
        bootstrap.connect(host,port);
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
