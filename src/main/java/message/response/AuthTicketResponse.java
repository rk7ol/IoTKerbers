package message.response;

import message.MessageType;
import module.ticket.TicketGrantingTicket;

public class AuthTicketResponse extends Response {
    private TicketGrantingTicket TGT;


    public AuthTicketResponse(int code, TicketGrantingTicket TGT) {
        super(MessageType.AUTH_TICKET_RESPONSE, code);
        this.TGT = TGT;
    }

    public TicketGrantingTicket getTGT() {
        return TGT;
    }

    public void setTGT(TicketGrantingTicket TGT) {
        this.TGT = TGT;
    }
}
