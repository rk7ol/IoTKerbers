package message.response;

import message.MessageType;

public class AccessKeyResponse extends Response{
    private byte[] cKC_TGS;

    public AccessKeyResponse( int code, byte[] cKC_TGS) {
        super(MessageType.ACCESS_KEY_RESPONSE, code);
        this.cKC_TGS = cKC_TGS;
    }

    public byte[] getcKC_TGS() {
        return cKC_TGS;
    }

    public void setcKC_TGS(byte[] cKC_TGS) {
        this.cKC_TGS = cKC_TGS;
    }
}
