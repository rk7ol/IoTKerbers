package config;

import module.Key;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;

public class Config {

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
            Key ServiceServerKey_V = new Key(properties.getProperty("ServiceServerKey").getBytes(StandardCharsets.UTF_8));
            long SST_ACTIVE_DURATION_V = Long.parseLong(properties.getProperty("SST_ACTIVE_DURATION"));

            config.setTIME_TOLERANCE(TIME_TOLERANCE_V);
            config.setServiceServerKey(ServiceServerKey_V);
            config.setSST_ACTIVE_DURATION(SST_ACTIVE_DURATION_V);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Map<String, Long> serviceAccessMap;

    long TIME_TOLERANCE;

    Key ServiceServerKey;

    long SST_ACTIVE_DURATION;


    private void setTIME_TOLERANCE(long TIME_TOLERANCE) {
        this.TIME_TOLERANCE = TIME_TOLERANCE;
    }

    public long getTIME_TOLERANCE() {
        return TIME_TOLERANCE;
    }

    private void setServiceServerKey(Key ServiceServerKey) {
        this.ServiceServerKey = ServiceServerKey;
    }

    public long getSST_ACTIVE_DURATION() {
        return SST_ACTIVE_DURATION;
    }

    private void setSST_ACTIVE_DURATION(long SST_ACTIVE_DURATION) {
        this.SST_ACTIVE_DURATION = SST_ACTIVE_DURATION;
    }

    public Key getTicketGrantingServerKey() {
        return ServiceServerKey;
    }

    public Map<String, Long> getServiceAccessMap() {
        return serviceAccessMap;
    }

    public void setServiceAccessMap(Map<String, Long> serviceAccessMap) {
        this.serviceAccessMap = serviceAccessMap;
    }
}
