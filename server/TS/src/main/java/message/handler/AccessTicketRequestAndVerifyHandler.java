package message.handler;

import config.Config;
import message.Message;
import message.message_handler.handler.MessageHandler;
import message.request.AccessRequestVerifyRequest;
import message.request.AccessTicketRequest;
import message.response.AccessTicketResponse;
import module.Key;
import module.ticket.Ticket;
import network.MessageSender;

import java.util.List;

//服务授权
public class AccessTicketRequestAndVerifyHandler extends MessageHandler {
    boolean handle(AccessTicketRequest accessTicketRequest, AccessRequestVerifyRequest accessRequestVerifyRequest, MessageSender messageSender){
        Ticket TGT =accessTicketRequest.getTGT();


        Key KTGS = Config.config.getTicketGrantingServerKey();

        //调用静态函数getTicketGrantingServerKey()获取KTGS，使用KTGS做为参数调用TGT的方法decrypt，解密TGT；
        byte[] bytes1=accessRequestVerifyRequest.getRequest_info();
        //使用解密后的TGT中的KC-TGS做为参数调用requestInfo中的方法decrypt，解密requestInfo；
        //若requestInfo中的timestamp与系统时间相差不大于配置常量TIME_TOLERANCE则转到 STEP 8
        //构造响应Access_Ticket_Response，code 为 3；
        AccessTicketResponse accessTicketResponse=new AccessTicketResponse(3,TGT);
        MessageSender.pushMessage(accessRequestVerifyRequest);

        return false;
    }

    @Override
    public boolean handle(List<Message> messages, MessageSender messageSender) {
        return false;
    }
}
