package message;

import java.util.Objects;

public abstract class Message {

    private MessageType type;

    public Message(MessageType type) {
        this.type = type;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != MessageType.class) return false;


        MessageType type = (MessageType) o;


        return this.type == type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

}
