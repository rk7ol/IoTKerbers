package message.message_handler.handler;

import message.Message;
import message.response.AccessKeyResponse;
import message.response.AccessTicketResponse;
import module.Key;
import network.MessageSender;

import java.util.List;
import java.util.Set;

public class AccessKeyResponseHandler extends MessageHandler{
    boolean handle(AccessKeyResponse accessKeyResponse , AccessTicketResponse accessTicketResponse,MessageSender messageSender){
        int KeyResponse=accessKeyResponse.getCode();
        int TicketResponse=accessTicketResponse.getCode();
        switch (KeyResponse){
            case 1:
                //则调用静态UI函数弹窗，内容是授权失败，用户id不匹配；
            case 2:
                //则调用静态UI函数弹窗，内容是授权失败，服务id不存在；
            case 3:
                //则调用静态UI函数弹窗，内容是授权失败，请求已过期；
            case 0:
                //获取accessKeyResponse中的加密后的KC-S记为K1
                //调用静态函数getPassword_hash64获取用户密码hash值，用该值解密K1得到KC-S，调用静态函数
                return true;
        }
        switch (TicketResponse){
            case 1:
                //则调用静态UI函数弹窗，内容是认证失败，用户不存在；
            case 0:
                //获取accessTicketResponse中的SST；
                accessTicketResponse.getTGT();
                return true;
            default:
                return false;
        }

    }

    @Override
    public boolean handle(List<Message> messages, MessageSender messageSender) {
        return false;
    }
}
