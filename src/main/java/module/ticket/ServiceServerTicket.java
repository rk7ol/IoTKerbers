package module.ticket;

import module.Key;

public class ServiceServerTicket extends Ticket{
    public ServiceServerTicket(Key key, String clientID, byte[] address, long validity) {
        super(key, clientID, address, validity);
    }
}
