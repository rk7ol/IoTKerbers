package message.request;

import message.MessageType;
import module.RequestInfo;

public class ServiceRequestVerifyRequest extends Request{
    private RequestInfo Request_info;

    public ServiceRequestVerifyRequest(RequestInfo request_info) {
        super(MessageType.SERVICE_REQUEST_VERIFY_REQUEST);
        Request_info = request_info;
    }

    public RequestInfo getRequest_info() {
        return Request_info;
    }

    public void setRequest_info(RequestInfo request_info) {
        Request_info = request_info;
    }
}
