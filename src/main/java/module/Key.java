package module;

public class Key {

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
}
