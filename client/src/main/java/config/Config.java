package config;

import module.Key;
import module.ticket.ServiceServerTicket;
import module.ticket.TicketGrantingTicket;

import java.util.Map;

public class Config {
    Key clientTicketGrantingServerSessionKey;

    Map<Long, Key> clientServiceServerSessionKeyMap;

    TicketGrantingTicket ticketGrantingTicket;

    Map<Long, ServiceServerTicket> serviceServerTicket;

    String clientID;

    byte[] password_hash64;

    public TicketGrantingTicket getTicketGrantingTicket() {
        return ticketGrantingTicket;
    }

    public boolean setTicketGrantingTicket(TicketGrantingTicket ticketGrantingTicket) {
        this.ticketGrantingTicket = ticketGrantingTicket;
        return true;
    }

    public ServiceServerTicket  getServiceServerTicket(long serviceID) {
        return this.serviceServerTicket.get(serviceID);
    }

    public boolean setServiceServerTicket(long serviceID, ServiceServerTicket ticket) {
        this.serviceServerTicket.put(serviceID,ticket);
        return true;
    }

    public byte[] getPassword_hash64() {
        return password_hash64;
    }

    public boolean setPassword_hash64(byte[] password_hash64) {
        this.password_hash64 = password_hash64;
        return true;
    }
}
