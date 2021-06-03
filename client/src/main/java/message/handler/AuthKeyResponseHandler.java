package message.handler;

import config.Config;
import message.Message;
import message.message_handler.handler.MessageHandler;
import message.response.AuthKeyResponse;
import message.response.AuthTicketResponse;
import module.Key;
import module.ticket.TicketGrantingTicket;
import network.MessageSender;
import network.NettyMessageSender;

import java.util.List;


public class AuthKeyResponseHandler extends MessageHandler {
    boolean handle(AuthKeyResponse authKeyResponse, AuthTicketResponse authTicketResponse, MessageSender sender){
        //Auth_Ticket_Response 消息处理函数
        int n=authTicketResponse.getCode();
        //Auth_Key_Response 消息处理函数
        int m=authKeyResponse.getCode();
        switch (n){
            case 1:{
                //调用静态UI函数，内存为认证失败，用户不存在
                System.out.println("UI");
                break;
            }
            case 0 : {
                TicketGrantingTicket TGT= authTicketResponse.getTGT();
                authTicketResponse.setTGT(TGT);
                break;
            }
            default:
                return false;
        }
        switch (m){
            case 1:{
                //调用静态UI函数，内存为认证失败，用户不存在
                break;
            }
            case 0 : {
                Key key=authKeyResponse.getKey_C_TGS();
                byte[] password_hash64=Config.config.getPassword_hash64();
                Key key1=new Key(password_hash64);
                //调用静态函数 getPassword_hash64 获取用户密码 hash 值，用该值解密 K1得到 KC-TGS
                key.decrypt(key1);
                Config.config.setClientTicketGrantingServerSessionKey(key);
                break;
            }
            default:
                return false;
        }
        return true;
    }



    @Override
    public boolean handle(List<Message> messages, MessageSender messageSender) {
        return false;
    }

    public static void main(String[] args) {

        AuthKeyResponseHandler authKeyResponseHandler = new AuthKeyResponseHandler();

        byte[] bytes = new byte[64];
        Key key = new Key(bytes);
        AuthKeyResponse authKeyResponse = new AuthKeyResponse(1, key);
        AuthTicketResponse authTicketResponse = new AuthTicketResponse(1, null);

        MessageSender sender = new NettyMessageSender();

        authKeyResponseHandler.handle(authKeyResponse, authTicketResponse, sender);

    }



}
