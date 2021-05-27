package config;

import module.Key;

public class Config {
    long TIME_TOLERANCE;

    Key ticketGrantingServerKey;

    long GT_ACTIVE_DURATION;

    public Key getTicketGrantingServerKey() {
        return ticketGrantingServerKey;
    }
}
