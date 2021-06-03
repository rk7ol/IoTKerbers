package message.response;

import message.MessageType;
import module.ticket.Ticket;

public class AccessTicketResponse extends Response{
    private Ticket TGT;

    public AccessTicketResponse(int code, Ticket TGT) {
        super(MessageType.ACCESS_TICKET_RESPONSE, code);
        this.TGT = TGT;
    }
    public Ticket getTGT() {
        return TGT;
    }

    public void setTGT(Ticket TGT) {
        this.TGT = TGT;
    }
}
