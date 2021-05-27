package config;

import module.Key;

public class Config {
    long TIME_TOLERANCE;

    Key ticketGrantingServerKey;

    Key serviceServerKey;

    long TGT_ACTIVE_DURATION;

    long SST_ACTIVE_DURATION;

    public Key getTicketGrantingServerKey() {
        return ticketGrantingServerKey;
    }

    public Key getServiceServerKey() {
        return serviceServerKey;
    }
}
