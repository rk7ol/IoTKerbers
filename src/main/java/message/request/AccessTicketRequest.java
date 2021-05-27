package message.request;

public class AccessTicketRequest extends Request{
    private byte[] TGT;

    public byte[] getTGT() {
        return TGT;
    }

    public void setTGT(byte[] TGT) {
        this.TGT = TGT;
    }
}
