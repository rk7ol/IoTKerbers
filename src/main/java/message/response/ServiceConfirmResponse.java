package message.response;

import message.MessageType;
import module.Timestamp;

public class ServiceConfirmResponse extends Response{
    private Timestamp ctimestamp;

    public ServiceConfirmResponse(int code, Timestamp ctimestamp) {
        super(MessageType.SERVICE_CONFIRM_RESPONSE, code);
        this.ctimestamp = ctimestamp;
    }

    public Timestamp getCtimestamp() {
        return ctimestamp;
    }

    public void setCtimestamp(Timestamp ctimestamp) {
        this.ctimestamp = ctimestamp;
    }
}
