package message.request;

public class ServiceRequestVerifyRequest extends Request{
    private byte[] Request_info;

    public byte[] getRequest_info() {
        return Request_info;
    }

    public void setRequest_info(byte[] request_info) {
        Request_info = request_info;
    }
}
