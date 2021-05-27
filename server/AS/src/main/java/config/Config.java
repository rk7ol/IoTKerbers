package config;

import module.Key;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Config {

    public static final Config config = new Config();

    public Config() {
    }

    public Config(long TIME_TOLERANCE, Key ticketGrantingServerKey, long GT_ACTIVE_DURATION) {
        this.TIME_TOLERANCE = TIME_TOLERANCE;
        this.ticketGrantingServerKey = ticketGrantingServerKey;
        this.GT_ACTIVE_DURATION = GT_ACTIVE_DURATION;
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
            long GT_ACTIVE_DURATION_V = Long.parseLong(properties.getProperty("GT_ACTIVE_DURATION"));

            config.setTIME_TOLERANCE(TIME_TOLERANCE_V);
            config.setTicketGrantingServerKey(ticketGrantingServerKey_V);
            config.setGT_ACTIVE_DURATION(GT_ACTIVE_DURATION_V);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    long TIME_TOLERANCE;

    Key ticketGrantingServerKey;

    long GT_ACTIVE_DURATION;


    private void setTIME_TOLERANCE(long TIME_TOLERANCE) {
        this.TIME_TOLERANCE = TIME_TOLERANCE;
    }

    public long getTIME_TOLERANCE() {
        return TIME_TOLERANCE;
    }


    private void setTicketGrantingServerKey(Key ticketGrantingServerKey) {
        this.ticketGrantingServerKey = ticketGrantingServerKey;
    }

    public long getGT_ACTIVE_DURATION() {
        return GT_ACTIVE_DURATION;
    }

    private void setGT_ACTIVE_DURATION(long GT_ACTIVE_DURATION) {
        this.GT_ACTIVE_DURATION = GT_ACTIVE_DURATION;
    }

    public Key getTicketGrantingServerKey() {
        return ticketGrantingServerKey;
    }

}
