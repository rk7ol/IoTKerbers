package util.cryption;

import util.serialization.JacksonEncoder;

public class DESCryptor extends Cryptor{



    @Override
    public byte[] crypt(byte[] plaintext, byte[] key) {
        return DES.crypt(plaintext, key);
    }
}
