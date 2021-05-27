package message.request;

import message.MessageType;

public class ServiceTicketRequest extends Request{
    private byte[] SST;

    public ServiceTicketRequest( byte[] SST) {
        super(MessageType.SERVICE_TICKET_REQUEST);
        this.SST = SST;
    }

    public byte[] getSST() {
        return SST;
    }

    public void setSST(byte[] SST) {
        this.SST = SST;
    }
}
