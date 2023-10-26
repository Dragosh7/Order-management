package org.example.presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Warehouse implements ActionListener {
    private JFrame frame = new JFrame("Warehouse");
    private JPanel panel = new JPanel();
    private JLabel labelClients = new JLabel("Clients");
    private JLabel labelProducts = new JLabel("Products");
    private JLabel labelOrders = new JLabel("Orders");
    private JButton btnAddClient = new JButton("Add");
    private JButton btnEditClient = new JButton("Edit");
    private JButton btnDeleteClient = new JButton("Delete");
    private JButton btnShowClients = new JButton("Show Clients");
    private JButton btnAddProduct = new JButton("Add");
    private JButton btnEditProduct = new JButton("Edit");
    private JButton btnDeleteProduct = new JButton("Delete");
    private JButton btnShowProducts = new JButton("Show Products");
    private JButton btnNewOrder = new JButton("New order");
    private JButton btnOrders = new JButton("Show Orders");

    public Warehouse() {
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        p1.add(labelClients);
        p1.add(btnAddClient);
        p1.add(btnEditClient);
        p1.add(btnDeleteClient);
        p1.add(btnShowClients);

        p2.add(labelProducts);
        p2.add(btnAddProduct);
        p2.add(btnEditProduct);
        p2.add(btnDeleteProduct);
        p2.add(btnShowProducts);

        p3.add(labelOrders);
        p3.add(btnNewOrder);
        p3.add(btnOrders);

        // seteaza layout-ul frame-ului
        frame.setLayout(new GridLayout(4, 1));

        // adauga panel-urile in frame
        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(panel);

        // seteaza proprietati frame-ului
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnAddClient.addActionListener(this);
        btnEditClient.addActionListener(this);
        btnDeleteClient.addActionListener(this);
        btnShowClients.addActionListener(this);
        btnAddProduct.addActionListener(this);
        btnEditProduct.addActionListener(this);
        btnDeleteProduct.addActionListener(this);
        btnShowProducts.addActionListener(this);
        btnNewOrder.addActionListener(this);
        btnOrders.addActionListener(this);

        btnAddClient.setFocusPainted(false);
        btnAddClient.setContentAreaFilled(false);
        btnEditClient.setFocusPainted(false);
        btnEditClient.setContentAreaFilled(false);
        btnDeleteClient.setFocusPainted(false);
        btnDeleteClient.setContentAreaFilled(false);
        btnShowClients.setFocusPainted(false);
        btnShowClients.setContentAreaFilled(false);

        btnAddProduct.setFocusPainted(false);
        btnAddProduct.setContentAreaFilled(false);
        btnEditProduct.setFocusPainted(false);
        btnEditProduct.setContentAreaFilled(false);
        btnDeleteProduct.setFocusPainted(false);
        btnDeleteProduct.setContentAreaFilled(false);
        btnShowProducts.setFocusPainted(false);
        btnShowProducts.setContentAreaFilled(false);

        btnNewOrder.setFocusPainted(false);
        btnNewOrder.setContentAreaFilled(false);
        btnOrders.setFocusPainted(false);
        btnOrders.setContentAreaFilled(false);

    }

    /**
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddClient) {
            ClientAdd addClients = new ClientAdd();
        }
        if (e.getSource() == btnEditClient) {
            ClientEdit editClients = new ClientEdit();
        }
        if (e.getSource() == btnDeleteClient) {
            ClientRemove removeClient = new ClientRemove();
        }
        if (e.getSource() == btnShowClients) {
            ClientsTable showClients = new ClientsTable(true);
        }
        if (e.getSource() == btnAddProduct) {
            ProductAdd addProduct = new ProductAdd();
        }
        if (e.getSource() == btnEditProduct) {
            ProductEdit editProduct = new ProductEdit();
        }
        if (e.getSource() == btnDeleteProduct) {
            ProductRemove removeProduct = new ProductRemove();
        }
        if (e.getSource() == btnShowProducts) {
            ProductTable showProducts = new ProductTable(true);
        }
        if (e.getSource() == btnNewOrder) {
            OrderCreate newOrder = new OrderCreate();
        }
        if (e.getSource() == btnOrders) {
            OrdersTable showOrders = new OrdersTable();
        }
    }
}
