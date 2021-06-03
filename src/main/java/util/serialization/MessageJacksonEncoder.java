package util.serialization;

import message.Message;
import message.request.AuthLoginRequest;

public class MessageJacksonEncoder extends JacksonEncoder<Message>{


    public static void main(String[] args) {
        MessageJacksonEncoder encoder = new MessageJacksonEncoder();
        MessageJacksonDecoder decoder = new MessageJacksonDecoder();

        Message message = new AuthLoginRequest("few");

        byte[] temp;

        temp = encoder.encode(message);

        Message deMessage  = decoder.decode(temp);

        System.out.println(deMessage.getClass());


    }
}
