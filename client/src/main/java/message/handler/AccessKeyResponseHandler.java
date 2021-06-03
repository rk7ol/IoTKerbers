package message.handler;

import config.Config;
import message.Message;
import message.message_handler.handler.MessageHandler;
import message.response.AccessKeyResponse;
import message.response.AccessTicketResponse;
import module.Key;
import module.ticket.ServiceServerTicket;
import network.MessageSender;
import network.NettyMessageSender;

import java.util.List;

public class AccessKeyResponseHandler extends MessageHandler {
    boolean handle(AccessKeyResponse accessKeyResponse , AccessTicketResponse accessTicketResponse,MessageSender messageSender){
        //Access_Key_Response 消息处理
        //Access_Ticket_Response 消息处理
        int KeyResponse=accessKeyResponse.getCode();
        int TicketResponse=accessTicketResponse.getCode();
        switch (KeyResponse){
            case 1:
               // System.out.println("UI");
                //则调用静态UI函数弹窗，内容是授权失败，用户id不匹配；
                break;
            case 2:
                //则调用静态UI函数弹窗，内容是授权失败，服务id不存在；
                break;
            case 3:
                //则调用静态UI函数弹窗，内容是授权失败，请求已过期；
                break;
            case 0:
                //获取accessKeyResponse中的加密后的KC-S记为K1
                Key bytes=accessKeyResponse.getcKC_TGS();
                //System.out.println(bytes);
                byte[] bytes1=Config.config.getPassword_hash64();
                //System.out.println(bytes1);
                Key key = new Key(bytes1);
                //System.out.println(key);
                bytes.decrypt(key);
                Config.config.setClientServiceServerSessionKey(bytes);
                //System.out.println(key);
                //调用静态函数getPassword_hash64获取用户密码hash值，用该值解密K1得到KC-S，调用静态函数
                break;
        }
        System.out.println("1");
        switch (TicketResponse){
            case 1:
                System.out.println("UI");
                break;
                //则调用静态UI函数弹窗，内容是认证失败，用户不存在；
            case 0:
                //获取accessTicketResponse中的SST；
                Config.config.setServiceServerTicket(1,accessTicketResponse.getSST());
                System.out.println("SST");
                break;
            default:
                return false;
        }
        return true;


    }

    @Override
    public boolean handle(List<Message> messages, MessageSender messageSender) {
        return false;
    }

    //测试部分
    public static void main(String[] args) {
        AccessKeyResponseHandler accessKeyResponseHandler=new AccessKeyResponseHandler();

        byte[] bytes = new byte[64];
        Key key = new Key(bytes);

        AccessKeyResponse accessKeyResponse = new AccessKeyResponse(1,key);

        AccessTicketResponse accessTicketResponse=new AccessTicketResponse(0,null);

        MessageSender messageSender=new NettyMessageSender() {
            @Override
            public byte[] getRemoteAddress() {
                return new byte[0];
            }
        };
        accessKeyResponseHandler.handle(accessKeyResponse,accessTicketResponse,messageSender);
    }
}
