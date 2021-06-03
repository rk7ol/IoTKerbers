package network;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import message.Message;
import network.codec.MessageDecoder;
import network.codec.MessageEncoder;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class KerberosNettyNetworkClient {
    private final Bootstrap bootstrap;
    private final EventLoopGroup workerGroup;


    public KerberosNettyNetworkClient() {
        this.workerGroup = new NioEventLoopGroup();
        this.bootstrap = new Bootstrap();
    }

    void initializeClient(){
        String d = "\123";
        ByteBuf delimiter = Unpooled.wrappedBuffer(d.getBytes(StandardCharsets.UTF_8));
        bootstrap.group(workerGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE,true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                  //      p.addLast(new MessageEncoder(d));
                  //      p.addLast(new MessageDecoder(10240, delimiter));

                        p.addLast(new ChannelInboundHandlerAdapter(){

                            @Override
                            public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                super.channelActive(ctx);

                                ctx.writeAndFlush("Hello from client");
                            }


                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                super.channelRead(ctx, msg);

                                System.out.println("server: " + msg);
                            }
                        });


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

            Message message = MessageSender.pollMessage();

        }

    }

    void shutdown(){
        workerGroup.shutdownGracefully();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        KerberosNettyNetworkClient client = new KerberosNettyNetworkClient();

        client.initializeClient();

        client.connect("127.0.0.1", 4122);



        while (true){

        }




    }
}
