import message.Message;
import message.MessageType;
import message.request.AuthLoginRequest;
import message.response.AuthTicketResponse;

public class MainApp {

    public static void main(String[] args) {


        Message message = new AuthLoginRequest("w");

        System.out.println(message.equals(MessageType.AUTH_LOGIN_REQUEST));

    }
}
