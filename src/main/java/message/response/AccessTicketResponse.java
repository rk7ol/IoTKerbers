package message.response;

import message.MessageType;
import module.ticket.Ticket;

public class AccessTicketResponse extends Response{
    private byte[] TGT;

    public AccessTicketResponse(int code, Ticket TGT) {
        super(MessageType.ACCESS_TICKET_RESPONSE, code);
        this.TGT = TGT;
    }
    public byte[] getTGT() {
        return TGT;
    }

    public void setTGT(byte[] TGT) {
        this.TGT = TGT;
    }
}
