package module;

public class RequestInfo extends CryptUnit{

    private String clientID;

    private Timestamp timestamp;

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    protected void decrypt(byte[] key) {

    }
}
