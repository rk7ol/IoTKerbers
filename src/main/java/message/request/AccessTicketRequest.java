package message.request;

import message.MessageType;

public class AccessTicketRequest extends Request{
    private byte[] TGT;

    public AccessTicketRequest( byte[] TGT) {
        super(MessageType.ACCESS_TICKET_REQUEST);
        this.TGT = TGT;
    }

    public byte[] getTGT() {
        return TGT;
    }

    public void setTGT(byte[] TGT) {
        this.TGT = TGT;
    }
}
