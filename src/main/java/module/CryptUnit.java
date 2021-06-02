package module;

import util.cryption.Cryptor;
import util.cryption.DESCryptor;
import util.cryption.DESDecryptor;
import util.cryption.Decryptor;

public abstract class CryptUnit {
    private byte[] ciphertext;
    private CryptState cryptState;


    protected static final Cryptor CRYPTOR = new DESCryptor();

    protected static final Decryptor DECRYPTOR = new DESDecryptor();

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

    private void encrypt(byte[] key){

    }

    public void encrypt(Key key){

        encrypt(key.getKey());

    }

    protected abstract void decrypt(byte[] key);

    public void decrypt(Key key){

        decrypt(key.getKey());

    }




}
