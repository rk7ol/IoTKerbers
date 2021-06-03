package message.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import message.MessageType;

public class AuthLoginRequest extends Request{
    private String username;

    @JsonCreator
    public AuthLoginRequest(@JsonProperty("username") String username) {
        super(MessageType.AUTH_LOGIN_REQUEST);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
