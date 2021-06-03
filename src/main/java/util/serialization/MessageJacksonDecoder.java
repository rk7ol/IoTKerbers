package util.serialization;

import message.Message;
import message.MessageType;
import message.request.AuthLoginRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MessageJacksonDecoder extends JacksonDecoder<Message> {

    private static final Map<MessageType, Class<? extends Message>> MESSAGE_TYPE_CLASS_MAP;

    static {
        MESSAGE_TYPE_CLASS_MAP = new HashMap<>();

        MESSAGE_TYPE_CLASS_MAP.put(MessageType.AUTH_LOGIN_REQUEST, AuthLoginRequest.class);
    }


    private Class<? extends Message> getClassByType(MessageType type) {

        return MESSAGE_TYPE_CLASS_MAP.get(type);

    }


    @Override
    public Message decode(byte[] bytes) {

        try {
            String type = objectMapper.readTree(bytes).get("type").asText();

            Class<? extends Message> messageClass = getClassByType(MessageType.valueOf(type));


            return objectMapper.readValue(bytes, messageClass);


        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
