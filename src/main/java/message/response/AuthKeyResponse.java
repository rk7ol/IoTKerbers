package message.response;

import message.MessageType;
import module.Key;

public class AuthKeyResponse extends Response{

    public AuthKeyResponse( int code, Key key_C_TGS) {
        super(MessageType.AUTH_KEY_RESPONSE, code);
        Key_C_TGS = key_C_TGS;
    }

    private Key Key_C_TGS;



    public Key getKey_C_TGS() {
        return Key_C_TGS;
    }

    public void setKey_C_TGS(Key key_C_TGS) {
        Key_C_TGS = key_C_TGS;
    }
}
