package config;

import module.Key;
import module.ticket.ServiceServerTicket;
import module.ticket.TicketGrantingTicket;

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
            Key clientTicketGrantingServerSessionKey_V = new Key(properties.getProperty("clientTicketGrantingServerSessionKey").getBytes(StandardCharsets.UTF_8));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public Key getClientTicketGrantingServerSessionKey() {
        return clientTicketGrantingServerSessionKey;
    }

    public void setClientTicketGrantingServerSessionKey(Key clientTicketGrantingServerSessionKey) {
        this.clientTicketGrantingServerSessionKey = clientTicketGrantingServerSessionKey;
    }

    public Map<Long, Key> getClientServiceServerSessionKeyMap() {
        return clientServiceServerSessionKeyMap;
    }

    public void setClientServiceServerSessionKeyMap(Map<Long, Key> clientServiceServerSessionKeyMap) {
        this.clientServiceServerSessionKeyMap = clientServiceServerSessionKeyMap;
    }

    public Map<Long, ServiceServerTicket> getServiceServerTicket() {
        return serviceServerTicket;
    }

    public void setServiceServerTicket(Map<Long, ServiceServerTicket> serviceServerTicket) {
        this.serviceServerTicket = serviceServerTicket;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }
}
