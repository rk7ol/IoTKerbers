package message.response;

import message.MessageType;
import module.Key;

public class AccessKeyResponse extends Response{
    private Key cKC_TGS;

    public AccessKeyResponse(int code, Key cKC_TGS) {
        super(MessageType.ACCESS_KEY_RESPONSE, code);
        this.cKC_TGS = cKC_TGS;
    }

    public Key getcKC_TGS() {
        return cKC_TGS;
    }

    public void setcKC_TGS(Key cKC_TGS) {
        this.cKC_TGS = cKC_TGS;
    }
}
