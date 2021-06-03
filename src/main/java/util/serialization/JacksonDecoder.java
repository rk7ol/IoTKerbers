package util.serialization;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public abstract class JacksonDecoder<T> extends Decoder<T> {

    ObjectMapper objectMapper = new ObjectMapper();

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }


}
