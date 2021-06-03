package util.cryption;

import com.fasterxml.jackson.databind.ObjectMapper;
import module.CryptUnit;
import util.serialization.JacksonDecoder;

public class DESDecryptor extends Decryptor{




    @Override
    public  byte[] decrypt(byte[] ciphertext, byte[] key) {
        return DES.decrypt(ciphertext, key);
    }
}
