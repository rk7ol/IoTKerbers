package message.response;

import message.Message;
import message.MessageType;

public abstract class Response extends Message {

    protected int code;

    public Response(MessageType type, int code) {
        super(type);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
