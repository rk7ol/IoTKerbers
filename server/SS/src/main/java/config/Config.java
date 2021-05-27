package config;

import module.Key;

import java.util.Map;

public class Config {
    Map<String, Long> servicieAccessMap;

    long TIME_TOLERANCE;

    Key serviceServerKey;

    long SST_ACTIVE_DURATION;

    public Key getServiceServerKey() {
        return serviceServerKey;
    }
}
