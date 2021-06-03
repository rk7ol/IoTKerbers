package message.request;

import message.MessageType;
import module.ticket.ServiceServerTicket;

public class AccessTicketRequest extends Request{
    private ServiceServerTicket TGT;

    public AccessTicketRequest(ServiceServerTicket TGT) {
        super(MessageType.ACCESS_TICKET_REQUEST);
        this.TGT = TGT;
    }

    public ServiceServerTicket getTGT() {
        return TGT;
    }

    public void setTGT(ServiceServerTicket TGT) {
        this.TGT = TGT;
    }
}
