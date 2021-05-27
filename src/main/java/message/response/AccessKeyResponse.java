package message.response;

public class AccessKeyResponse extends Response{
    private byte[] cKC_TGS;

    public byte[] getcKC_TGS() {
        return cKC_TGS;
    }

    public void setcKC_TGS(byte[] cKC_TGS) {
        this.cKC_TGS = cKC_TGS;
    }
}
