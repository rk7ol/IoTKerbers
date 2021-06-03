package module.ticket;

import module.CryptUnit;
import module.Key;

public class Ticket extends CryptUnit {

    protected Key key;

    protected String clientID;

    protected byte[] address;

    protected long validity;

    public Ticket(Key key, String clientID, byte[] address, long validity) {
        this.key = key;
        this.clientID = clientID;
        this.address = address;
        this.validity = validity;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public byte[] getAddress() {
        return address;
    }

    public void setAddress(byte[] address) {
        this.address = address;
    }

    public long getValidity() {
        return validity;
    }

    public void setValidity(long validity) {
        this.validity = validity;
    }

    @Override
    protected void decrypt(byte[] key) {

    }
}
