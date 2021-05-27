package message.message_handler.handler;

import message.Message;
import message.request.AccessRequestVerifyRequest;
import message.request.AccessTicketRequest;
import message.response.AccessTicketResponse;
import network.MessageSender;

import java.util.List;

public class AccessTicketRequestAndVerifyHandler extends MessageHandler{
    boolean handle(AccessTicketRequest accessTicketRequest, AccessRequestVerifyRequest accessRequestVerifyRequest, MessageSender messageSender){
        byte[] bytes=accessTicketRequest.getTGT();
        need fix //调用静态函数getTicketGrantingServerKey()获取KTGS，使用KTGS做为参数调用TGT的方法decrypt，解密TGT
        accessRequestVerifyRequest.getRequest_info();
        need fix//使用解密后的TGT中的KC-TGS做为参数调用requestInfo中的方法decrypt，解密requestInfo；
        AccessTicketResponse accessTicketResponse=new AccessTicketResponse(3,bytes);
        MessageSender.pushMessage(accessTicketResponse);
        return false;
    }

    @Override
    public boolean handle(List<Message> messages, MessageSender messageSender) {
        return false;
    }
}
