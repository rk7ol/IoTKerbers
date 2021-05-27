package message.request;

import message.MessageType;

public class ServiceRequestVerifyRequest extends Request{
    private byte[] Request_info;

    public ServiceRequestVerifyRequest( byte[] request_info) {
        super(MessageType.SERVICE_REQUEST_VERIFY_REQUEST);
        Request_info = request_info;
    }

    public byte[] getRequest_info() {
        return Request_info;
    }

    public void setRequest_info(byte[] request_info) {
        Request_info = request_info;
    }
}
