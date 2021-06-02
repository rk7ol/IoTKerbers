package util.cryption;

public abstract class Decryptor {

    public abstract byte[] decrypt(byte[] ciphertext, byte[] key);
}
