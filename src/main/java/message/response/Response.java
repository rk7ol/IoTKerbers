package message.response;

import message.Message;

public abstract class Response extends Message {

    protected int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
