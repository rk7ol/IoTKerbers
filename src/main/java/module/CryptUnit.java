package module;

public abstract class CryptUnit {
    private byte[] ciphertext;
    private CryptState cryptState;

    public byte[] getCiphertext() {
        return ciphertext;
    }

    public void setCiphertext(byte[] ciphertext) {
        this.ciphertext = ciphertext;
    }

    public CryptState getCryptState() {
        return cryptState;
    }

    public void setCryptState(CryptState cryptState) {
        this.cryptState = cryptState;
    }

    public void encrypt(byte[] key){

    }

    public void decrypt(byte[] key){

    }


}
