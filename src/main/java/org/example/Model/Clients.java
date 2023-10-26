package org.example.Model;

public class Clients {
    private int id;
    private String clientName;
    private String clientAddress;
    private String clientEmail;

    public Clients() {
    }

    /**
     *
     * @param clientName
     * @param clientAddress
     * @param clientEmail
     */
    public Clients(String clientName, String clientAddress, String clientEmail) {
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientEmail = clientEmail;
    }

    /**
     *
     * @param clientId
     * @param clientName
     * @param clientAddress
     * @param clientEmail
     */
    public Clients(int clientId, String clientName, String clientAddress, String clientEmail) {
        this.id = clientId;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientEmail = clientEmail;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getClientName() {
        return clientName;
    }

    /**
     *
     * @param clientName
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     *
     * @return
     */
    public String getClientAddress() {
        return clientAddress;
    }

    /**
     *
     * @param clientAddress
     */
    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    /**
     *
     * @return
     */
    public String getClientEmail() {
        return clientEmail;
    }

    /**
     *
     * @param clientEmail
     */
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Client: " +
                "[ id=" + id +
                ", name=" + clientName +
                ", address=" + clientAddress +
                ", email=" + clientEmail + "]";
    }
}