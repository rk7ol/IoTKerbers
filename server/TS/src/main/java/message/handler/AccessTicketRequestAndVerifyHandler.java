package message.handler;

import config.Config;
import message.Message;
import message.message_handler.handler.MessageHandler;
import message.request.AccessRequestVerifyRequest;
import message.request.AccessTicketRequest;
import message.response.AccessKeyResponse;
import message.response.AccessTicketResponse;
import module.Key;
import module.RequestInfo;
import module.ticket.ServiceServerTicket;
import module.ticket.TicketGrantingTicket;
import network.MessageSender;
import util.Util;

import java.util.List;

//服务授权
public class AccessTicketRequestAndVerifyHandler extends MessageHandler {
    //Access_Ticket_Request 和 Access_Request_Verify_Request 消息处理
    boolean handle(AccessTicketRequest accessTicketRequest, AccessRequestVerifyRequest accessRequestVerifyRequest, MessageSender messageSender){
        //从accessTicketRequest中获取TGT
        ServiceServerTicket TGT =accessTicketRequest.getTGT();
        int a=1;//测试用
        //调用静态函数getTicketGrantingServerKey()获取KTGS，使用KTGS做为参数调用TGT的方法decrypt，解密TGT；
        TGT.decrypt(Config.config.getTicketGrantingServerKey());

        //从accessRequestVerifyRequest中获取requestInfo；
        RequestInfo requestInfo=accessRequestVerifyRequest.getRequest_info();

        //使用解密后的TGT中的KC-TGS做为参数调用requestInfo中的方法decrypt，解密requestInfo；
        requestInfo.decrypt(TGT.getKey());

        //使用KC-S (byte[])，用户名(String)，用户网络地址(byte[])，有效期(long)生成SST，
        // 用户网络地址通过参数messageSender的方法getRemoteAddress()获取，有效期为当前系统时间加上配置常量SST_ACTIVE_DURATION；
        Key key=new Key(Util.random64Bits());
        ServiceServerTicket serviceServerTicket=new ServiceServerTicket(key,requestInfo.getClientID(),messageSender.getRemoteAddress(),System.currentTimeMillis()+Config.config.getSST_ACTIVE_DURATION());
        serviceServerTicket.encrypt(Config.config.getServiceServerKey());
        key.decrypt(Config.config.getTicketGrantingServerKey());
        //若requestInfo中的timestamp与系统时间相差不大于配置常量TIME_TOLERANCE则转到 STEP 8；
        if(requestInfo.getTimestamp().getTimestamp()-System.currentTimeMillis()>Config.config.getTIME_TOLERANCE()){
            //构造响应Access_Ticket_Response，code 为 3；
            //发送响应Access_Ticket_Response，返回true；
            AccessTicketResponse accessTicketResponse=new AccessTicketResponse(3, null);
            MessageSender.pushMessage(accessTicketResponse);
            return true;
        }else if(requestInfo.getClientID()!=TGT.getClientID()){
            AccessTicketResponse accessTicketResponse=new AccessTicketResponse(1,null);
            MessageSender.pushMessage(accessTicketResponse);
            return true;
        }else if(a>0){
            AccessTicketResponse accessTicketResponse=new AccessTicketResponse(2,null);
            MessageSender.pushMessage(accessTicketResponse);
        }else {
            AccessTicketResponse accessTicketResponse=new AccessTicketResponse(0,serviceServerTicket);
            AccessKeyResponse accessKeyResponse=new AccessKeyResponse(0,key);
            MessageSender.pushMessage(accessTicketResponse);
            MessageSender.pushMessage(accessKeyResponse);
        }

        return false;
    }

    @Override
    public boolean handle(List<Message> messages, MessageSender messageSender) {
        return false;
    }
}
