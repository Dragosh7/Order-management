package org.example.Model;

public class Orders {
    private int id;
    private int clientsID;
    private int productID;
    private int quantity;

    /**
     *
     * @param clientID
     * @param productID
     * @param quantity
     */
    public Orders(int clientID, int productID, int quantity) {
        this.clientsID = clientID;
        this.productID = productID;
        this.quantity = quantity;
    }

    public Orders() {
    }

    /**
     *
     * @param orderID
     * @param clientID
     * @param productID
     * @param quantity
     */
    public Orders(int orderID, int clientID, int productID, int quantity) {
        this.id = orderID;
        this.clientsID = clientID;
        this.productID = productID;
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    public int getOrdersID() {
        return id;
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
    public int getClientsID() {
        return clientsID;
    }

    /**
     *
     * @param clientsID
     */
    public void setClientsID(int clientsID) {
        this.clientsID = clientsID;
    }

    /**
     *
     * @return
     */
    public int getProductID() {
        return productID;
    }

    /**
     *
     * @param productID
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Order: " +
                "[ id=" + id +
                ", client id=" + clientsID +
                ", product id=" + productID +
                ", quantity=" + quantity + "]";
    }
}