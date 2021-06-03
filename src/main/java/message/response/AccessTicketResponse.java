package message.response;

import message.MessageType;
import module.ticket.ServiceServerTicket;
import module.ticket.Ticket;

public class AccessTicketResponse extends Response{
    private ServiceServerTicket SST;

    public AccessTicketResponse(int code, ServiceServerTicket SST) {
        super(MessageType.ACCESS_TICKET_RESPONSE, code);
        this.SST = SST;
    }
    public ServiceServerTicket getSST() {
        return SST;
    }

    public void setSST(ServiceServerTicket SST) {
        this.SST = SST;
    }
}
