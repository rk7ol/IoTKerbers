package module;

import util.serialization.JacksonDecoder;

import java.io.IOException;

public class Timestamp extends CryptUnit {

    private static final JacksonDecoder<Timestamp> timestampJacksonDecoder = new JacksonDecoder<Timestamp>() {
        @Override
        public Timestamp decode(byte[] bytes) {

            try {
                return getObjectMapper().readValue(bytes, Timestamp.class);
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
    };

    private long timestamp;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    protected void decrypt(byte[] key) {


        byte[] plaintext = DECRYPTOR.decrypt(getCiphertext(), key);

        setCryptState(CryptState.DECRYPTED);

        Timestamp timestamp = timestampJacksonDecoder.decode(plaintext);

        this.timestamp = timestamp.timestamp;


    }
}
