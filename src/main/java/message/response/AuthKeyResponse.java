package message.response;

import module.Key;

public class AuthKeyResponse extends Response{
    private int code;
    private Key Key_C_TGS;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Key getKey_C_TGS() {
        return Key_C_TGS;
    }

    public void setKey_C_TGS(Key key_C_TGS) {
        Key_C_TGS = key_C_TGS;
    }
}
