package message.message_handler.handler;

import message.Message;
import message.response.AuthKeyResponse;
import message.response.AuthTicketResponse;
import module.ticket.TicketGrantingTicket;
import network.MessageSender;

import java.util.Set;

public class AuthKeyResponseHandler extends MessageHandler{
    boolean handle(AuthKeyResponse authKeyResponse, AuthTicketResponse authTicketResponse, MessageSender sender){
        //Auth_Ticket_Response 消息处理函数
        int n=authKeyResponse.getCode();
        switch (n){
            case 1:{
                //调用静态UI函数，内存为认证失败，用户不存在
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
        return true;
    }

    @Override
    boolean handle(Set<Message> messages, MessageSender messageSender) {
        return false;
    }
}
