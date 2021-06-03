package message.request;

import message.MessageType;
import module.ticket.Ticket;

public class ServiceTicketRequest extends Request{
    private Ticket SST;

    public ServiceTicketRequest(Ticket SST) {
        super(MessageType.SERVICE_TICKET_REQUEST);
        this.SST = SST;
    }

    public Ticket getSST() {
        return SST;
    }

    public void setSST(Ticket SST) {
        this.SST = SST;
    }
}
