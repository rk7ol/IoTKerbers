package message.request;

import message.MessageType;
import module.ticket.Ticket;

public class AccessTicketRequest extends Request{
    private Ticket TGT;

    public AccessTicketRequest(Ticket TGT) {
        super(MessageType.ACCESS_TICKET_REQUEST);
        this.TGT = TGT;
    }

    public Ticket getTGT() {
        return TGT;
    }

    public void setTGT(Ticket TGT) {
        this.TGT = TGT;
    }
}
