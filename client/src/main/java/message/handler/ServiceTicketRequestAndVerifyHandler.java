package message.handler;

import config.Config;
import message.Message;
import message.message_handler.handler.MessageHandler;
import message.request.ServiceRequestVerifyRequest;
import message.request.ServiceTicketRequest;
import message.response.ServiceConfirmResponse;
import module.Key;
import module.RequestInfo;
import module.Timestamp;
import module.ticket.Ticket;
import network.MessageSender;

import java.util.List;

public class ServiceTicketRequestAndVerifyHandler extends MessageHandler {
    boolean handle(ServiceTicketRequest serviceTicketRequest, ServiceRequestVerifyRequest serviceRequestVerifyRequest, MessageSender messageSender) {
        //从serviceTicketRequest中获取SST；
        ServiceTicketRequest serviceTicketRequest1 = new ServiceTicketRequest(serviceTicketRequest.getSST());
        Ticket SST = serviceTicketRequest.getSST();

        //调用静态函数getServiceServerKey()获取KS，使用KS做为参数调用SST的方法decrypt，解密SST；
        byte[] bytes1 = Config.config.getServiceServerKey();
        Key KS = new Key(bytes1);
        SST.decrypt(KS);

        //从serviceRequestVerifyRequest中获取requestInfo；
        RequestInfo request_info = serviceRequestVerifyRequest.getRequest_info();
        //使用解密后的SST中的KC-S做为参数调用requestInfo中的方法decrypt，解密requestInfo；
        request_info.decrypt(SST.getKey());
        //若requestInfo中的timestamp与系统时间相差不大于配置常量TIME_TOLERANCE则转到STEP 8；
        if (request_info.getTimestamp() - System.currentTimeMillis() <= 100) {
            //构造响应Service_Confirm，code 为 3；
            //发送响应Service_Confirm，返回true；
            ServiceConfirmResponse serviceConfirmResponse = new ServiceConfirmResponse(3, null);
            MessageSender.pushMessage(serviceConfirmResponse);
            return true;
        } else if (request_info.getClientID().equals(SST.getClientID())) {//比对解密后的SST中client id与解密后的requestInfo中的client id，若匹配则转STEP 11；
            Timestamp timestamp = new Timestamp();
            timestamp.encrypt(SST.getKey());
            //使用加密后的timestamp构造响应Service_Confirm，code 为 0；
            ServiceConfirmResponse serviceConfirmResponse = new ServiceConfirmResponse(0, timestamp.getTimestamp());
            //发送响应Service_Confirm，返回true。
            MessageSender.pushMessage(serviceConfirmResponse);
        } else {
            //构造响应Service_Confirm，code 为 1；
            ServiceConfirmResponse serviceConfirmResponse = new ServiceConfirmResponse(1, null);
            MessageSender.pushMessage(serviceConfirmResponse);
            return true;
        }
        return false; JJ}

    @Override
    public boolean handle(List<Message> messages, MessageSender messageSender) {
        return false;
    }
}
