package message.request;

import message.MessageType;

public class AuthLoginRequest extends Request{
    private String username;

    public AuthLoginRequest(String username) {
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
