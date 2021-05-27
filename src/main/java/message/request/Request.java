package message.request;

import message.Message;
import message.MessageType;

public abstract class Request extends Message {

    public Request(MessageType type) {
        super(type);
    }
}
