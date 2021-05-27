package message.request;

public class AccessRequestVerifyRequest extends Request{
    private long service_id;
    private byte[] request_info;

    public long getService_id() {
        return service_id;
    }

    public void setService_id(long service_id) {
        this.service_id = service_id;
    }

    public byte[] getRequest_info() {
        return request_info;
    }

    public void setRequest_info(byte[] request_info) {
        this.request_info = request_info;
    }
}