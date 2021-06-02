package util.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class JacksonEncoder<T> extends Encoder<T>{

    ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public byte[] encode(T t) {
        try {
            return objectMapper.writeValueAsBytes(t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
