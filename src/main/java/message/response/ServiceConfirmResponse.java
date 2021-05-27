package message.response;

public class ServiceConfirmResponse extends Response{
    private byte[] ctimestamp;

    public byte[] getCtimestamp() {
        return ctimestamp;
    }

    public void setCtimestamp(byte[] ctimestamp) {
        this.ctimestamp = ctimestamp;
    }
}
