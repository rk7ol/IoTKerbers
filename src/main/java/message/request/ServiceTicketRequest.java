package message.request;

public class ServiceTicketRequest extends Request{
    private byte[] SST;

    public byte[] getSST() {
        return SST;
    }

    public void setSST(byte[] SST) {
        this.SST = SST;
    }
}
