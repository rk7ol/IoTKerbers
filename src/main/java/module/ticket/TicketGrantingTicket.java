package module.ticket;

import module.Key;

public class TicketGrantingTicket extends Ticket{


    public TicketGrantingTicket(Key key, String clientID, byte[] address, long validity) {
        super(key, clientID, address, validity);
    }
}
