package config;

import module.Key;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Config {
    long TIME_TOLERANCE;

    Key ticketGrantingServerKey;

    Key serviceServerKey;

    long TGT_ACTIVE_DURATION;

    long SST_ACTIVE_DURATION;

    public static final Config config = new Config();

    public Config() {
    }

    static {
        try {
            Properties properties = new Properties();
            // 使用InPutStream流读取properties文件
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./config.properties"));
            properties.load(bufferedReader);
            // 获取key对应的value值
            long TIME_TOLERANCE_V = Long.parseLong(properties.getProperty("TIME_TOLERANCE"));
            Key ticketGrantingServerKey_V = new Key(properties.getProperty("ticketGrantingServerKey").getBytes(StandardCharsets.UTF_8));
            long TGT_ACTIVE_DURATION_V = Long.parseLong(properties.getProperty("TGT_ACTIVE_DURATION"));
            long SST_ACTIVE_DURATION_V = Long.parseLong(properties.getProperty("SST_ACTIVE_DURATION"));
            Key serviceServerKey_V = new Key(properties.getProperty("serviceServerKey").getBytes(StandardCharsets.UTF_8));


            config.setTIME_TOLERANCE(TIME_TOLERANCE_V);
            config.setServiceServerKey(serviceServerKey_V);
            config.setTGT_ACTIVE_DURATION(TGT_ACTIVE_DURATION_V);
            config.setSST_ACTIVE_DURATION(SST_ACTIVE_DURATION_V);
            config.setTicketGrantingServerKey(ticketGrantingServerKey_V);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Key getTicketGrantingServerKey() {
        return ticketGrantingServerKey;
    }

    public Key getServiceServerKey() {
        return serviceServerKey;
    }

    public long getTIME_TOLERANCE() {
        return TIME_TOLERANCE;
    }

    public void setTIME_TOLERANCE(long TIME_TOLERANCE) {
        this.TIME_TOLERANCE = TIME_TOLERANCE;
    }

    public void setTicketGrantingServerKey(Key ticketGrantingServerKey) {
        this.ticketGrantingServerKey = ticketGrantingServerKey;
    }

    public void setServiceServerKey(Key serviceServerKey) {
        this.serviceServerKey = serviceServerKey;
    }

    public long getTGT_ACTIVE_DURATION() {
        return TGT_ACTIVE_DURATION;
    }

    public void setTGT_ACTIVE_DURATION(long TGT_ACTIVE_DURATION) {
        this.TGT_ACTIVE_DURATION = TGT_ACTIVE_DURATION;
    }

    public long getSST_ACTIVE_DURATION() {
        return SST_ACTIVE_DURATION;
    }

    public void setSST_ACTIVE_DURATION(long SST_ACTIVE_DURATION) {
        this.SST_ACTIVE_DURATION = SST_ACTIVE_DURATION;
    }
}
