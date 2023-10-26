package org.example.Model;
public class Product {

    private int id;
    private String productName;
    private int productPrice;
    private int productStock;

    public Product() {
    }

    /**
     *
     * @param name
     * @param price
     * @param stock
     */
    public Product(String name, int price, int stock) {
        this.productName = name;
        this.productPrice = price;
        this.productStock = stock;
    }

    /**
     *
     * @param productID
     * @param productName
     * @param productPrice
     * @param productStock
     */

    public Product(int productID, String productName, int productPrice, int productStock) {
        this.id = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
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
    public String getProductName() {
        return productName;
    }

    /**
     *
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     *
     * @return
     */
    public int getProductPrice() {
        return productPrice;
    }

    /**
     *
     * @param productPrice
     */
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    /**
     *
     * @return
     */
    public int getProductStock() {
        return productStock;
    }

    /**
     *
     * @param productStock
     */
    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Product: " +
                "[ id=" + id +
                ", name=" + productName +
                ", price=" + productPrice +
                ", stock=" + productStock +
                 "]";
    }
}