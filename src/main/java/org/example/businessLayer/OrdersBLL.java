package org.example.businessLayer;

import org.example.dataAccessLayer.OrdersDAO;
import org.example.Model.Orders;

import java.util.List;

public class OrdersBLL {

    private OrdersDAO ordersDAO = new OrdersDAO();

    /**
     *
     * @return
     */
    public String[] getFieldNames(){
        String[] s = ordersDAO.takeFieldNames();
        return s;
    }

    /**
     *
     * @return
     */
    public String[][] getListOfOrders(){
        String[][] s = ordersDAO.listOfObject(ordersDAO.findAll());
        return s;
    }

    /**
     *
     * @param product
     * @return
     */
    public Orders insertOrders(Orders product) {
        return ordersDAO.insert(product);
    }

    /**
     *
     * @return
     */
    public List<Orders> findAllOrders() {
        return ordersDAO.findAll();
    }
}