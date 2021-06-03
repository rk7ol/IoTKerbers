package message.request;

import message.MessageType;
import module.RequestInfo;

public class AccessRequestVerifyRequest extends Request{
    private long service_id;
    private RequestInfo request_info;


    public AccessRequestVerifyRequest(long service_id, RequestInfo request_info) {
        super(MessageType.ACCESS_REQUEST_VERIFY_REQUEST);
        this.service_id = service_id;
        this.request_info = request_info;
    }

    public long getService_id() {
        return service_id;
    }

    public void setService_id(long service_id) {
        this.service_id = service_id;
    }

    public RequestInfo getRequest_info() {
        return request_info;
    }

    public void setRequest_info(RequestInfo request_info) {
        this.request_info = request_info;
    }
}
