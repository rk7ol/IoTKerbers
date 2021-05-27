package message.response;

import message.MessageType;

public class ServiceConfirmResponse extends Response{
    private byte[] ctimestamp;

    public ServiceConfirmResponse( int code, byte[] ctimestamp) {
        super(MessageType.SERVICE_CONFIRM_RESPONSE, code);
        this.ctimestamp = ctimestamp;
    }

    public byte[] getCtimestamp() {
        return ctimestamp;
    }

    public void setCtimestamp(byte[] ctimestamp) {
        this.ctimestamp = ctimestamp;
    }
}
