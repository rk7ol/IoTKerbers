package module;

public class Key extends CryptUnit{

    private byte[] key;

    public byte[] getKey() {
        return key;
    }

    public void setKey(byte[] key) {
        this.key = key;
    }

    public Key(byte[] key) {
        this.key = key;
    }

    @Override
    protected void decrypt(byte[] key) {

    }
}
