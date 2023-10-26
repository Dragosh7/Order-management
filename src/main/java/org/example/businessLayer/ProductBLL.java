package org.example.businessLayer;

import org.example.dataAccessLayer.ProductDAO;
import org.example.Model.Product;

import javax.swing.*;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductBLL {

    ProductDAO productDAO = new ProductDAO();

    /**
     *
     * @param id
     * @return
     */
    public Product findProductById(int id) {
        Product product = productDAO.findById(id);
        if (product == null) {
            JOptionPane.showMessageDialog(null, "Produs inexistent!");
            throw new NoSuchElementException("The product with productID =" + id + " was not found!");
        }
        return product;
    }


    public String[] getFieldNames(){
        String[] toReturn = productDAO.takeFieldNames();
        return toReturn;
    }

    /**
     *
     * @return
     */
    public String[][] getListOfProducts(){
        String[][] toReturn = productDAO.listOfObject(productDAO.findAll());
        return toReturn;
    }

    /**
     *
     * @param product
     * @return
     */
    public Product insertProduct(Product product) {
        return productDAO.insert(product);
    }

    /**
     *
     * @param productID
     */
    public void deleteProduct(int productID) {
        productDAO.delete(productID);
    }

    /**
     *
     * @return
     */
    public List<Product> findAllProducts() {
        return productDAO.findAll();
    }

    /**
     *
     * @param product
     * @return
     */

    public Product updateProduct(Product product) {
        return productDAO.update(product, product.getId());
    }
}