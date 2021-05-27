package message.response;

import module.ticket.TicketGrantingTicket;

public class AuthTicketResponse extends Response {
    private int code;
    private TicketGrantingTicket TGT;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public TicketGrantingTicket getTGT() {
        return TGT;
    }

    public void setTGT(TicketGrantingTicket TGT) {
        this.TGT = TGT;
    }
}
