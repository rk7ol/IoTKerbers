package config;

import message.MessageType;
import module.Key;
import module.ticket.ServiceServerTicket;
import module.ticket.TicketGrantingTicket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Config {

    public static final Config config = new Config();
    public Key clientServiceServerSessionKey;



    public Config() {
    }

    
    private static Map<MessageType, String> typeAddressMap;

    private static Map<MessageType, Integer> typePortMap;

    static {
        try {
            Properties properties = new Properties();
            // 使用InPutStream流读取properties文件
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./config.properties"));
            properties.load(bufferedReader);
            // 获取key对应的value值
            //Key clientTicketGrantingServerSessionKey_V = new Key(properties.getProperty("clientTicketGrantingServerSessionKey").getBytes(StandardCharsets.UTF_8));


            String ASAddress = properties.getProperty("ASAddress");
            int ASPort = Integer.parseInt(properties.getProperty("ASPort"));
            typeAddressMap = new HashMap<>();
            typePortMap = new HashMap<>();

            typeAddressMap.put(MessageType.AUTH_LOGIN_REQUEST, ASAddress);
            typePortMap.put(MessageType.AUTH_LOGIN_REQUEST, ASPort);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getAddressByMessageType(MessageType type){
        return typeAddressMap.get(type);
    }

    public static int getPortByMessageType(MessageType type){
        return typePortMap.get(type);
    }




    Key clientTicketGrantingServerSessionKey;

    Map<Long, Key> clientServiceServerSessionKeyMap;

    TicketGrantingTicket ticketGrantingTicket;

    Map<Long, ServiceServerTicket> serviceServerTicket;

    String clientID;

    public byte[] getServiceServerKey() {
        return ServiceServerKey;
    }

    public void setServiceServerKey(byte[] serviceServerKey) {
        ServiceServerKey = serviceServerKey;
    }

    byte[] ServiceServerKey;



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

    public Key getClientServiceServerSessionKey() {
        return clientServiceServerSessionKey;
    }

    public void setClientServiceServerSessionKey(Key clientServiceServerSessionKey) {
        this.clientServiceServerSessionKey = clientServiceServerSessionKey;
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

    public void addServiceServerTicket(Long serviceID, ServiceServerTicket ticket){
        serviceServerTicket.put(serviceID, ticket);
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

}
