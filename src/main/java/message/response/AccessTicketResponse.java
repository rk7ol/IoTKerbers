package message.response;

public class AccessTicketResponse extends Response{
    private byte[] TGT;

    public byte[] getTGT() {
        return TGT;
    }

    public void setTGT(byte[] TGT) {
        this.TGT = TGT;
    }
}
