package org.example.presentation;

import org.example.Model.Bill;
import org.example.businessLayer.ClientBLL;
import org.example.businessLayer.OrdersBLL;
import org.example.businessLayer.ProductBLL;
import org.example.Model.Clients;
import org.example.Model.Orders;
import org.example.Model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

public class OrderCreate implements ActionListener {
    private ClientsTable c = new ClientsTable(false);
    private ProductTable p = new ProductTable(false);
    JFrame frame = new JFrame("Create an order");
    private JTable clientTable;
    private JTable productTable;
    private DefaultTableModel clientTableModel;
    private DefaultTableModel productTableModel;

    private JPanel panel = new JPanel();
    private JTextField textQuantity = new JTextField();
    private JButton btnNewOrder = new JButton("Add Order");
    private String[][] clientsData, productsData;

    /**
     *
     * @param clientName
     * @param productName
     * @param price
     * @param adress
     */
    private static void  insertBill(String clientName,String productName,double price,String adress)
    {
        ResultSet rs;
        Connection connection;
        Statement statement;
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost/warehouse?user=root&password=admin&serverTimezone=UTC");
            statement = connection.createStatement();
            statement.execute("call warehouse.new_procedure('" + clientName + "', '" + productName + "', " + price + ", '" + adress + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public OrderCreate() {

        JLabel labelQuantity = new JLabel("Enter the desired quantity:");
        JPanel upPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        ClientBLL clientBLL = new ClientBLL();
        ProductBLL productBLL = new ProductBLL();
        productsData = new String[200][4];
        clientsData = new String[200][4];
        List<Clients> list1 = clientBLL.findAllClients();
        int i = 0;
        for (Clients c : list1) {
            clientsData[i][0] = String.valueOf(c.getId());
            clientsData[i][1] = c.getClientName();
            clientsData[i][2] = c.getClientAddress();
            clientsData[i][3] = c.getClientEmail();
            i++;
        }

        List<Product> list2 = productBLL.findAllProducts();
        i = 0;
        for (Product p : list2) {
            productsData[i][0] = String.valueOf(p.getId());
            productsData[i][1] = p.getProductName();
            productsData[i][2] = String.valueOf(p.getProductPrice());
            productsData[i][3] = String.valueOf(p.getProductStock());
            i++;
        }

        clientTable = c.getTable();
        productTable = p.getTable();

        JScrollPane js1 = new JScrollPane(clientTable);
        JScrollPane js2 = new JScrollPane(productTable);

        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(js1, BorderLayout.CENTER);

        rightPanel.setLayout(new BorderLayout());
        rightPanel.add(js2, BorderLayout.CENTER);

        upPanel.add(leftPanel);
        upPanel.add(rightPanel);

        labelQuantity.setBounds(200, 30, 700, 30);
        textQuantity.setBounds(400, 30, 200, 30);
        btnNewOrder.setBounds(400, 60, 200, 30);

        btnNewOrder.addActionListener(this);

        bottomPanel.add(labelQuantity);
        bottomPanel.add(textQuantity);
        bottomPanel.add(btnNewOrder);
        bottomPanel.setLayout(null);


        panel.add(upPanel);
        panel.add(bottomPanel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        frame.setVisible(true);
        frame.setSize(1000, 700);
        frame.setContentPane(panel);
    }

    /**
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNewOrder) {
            // Check if both a client and product are selected
            if (clientTable.getSelectedRow() == -1 || productTable.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(btnNewOrder, "Selectati un produs si un client!");
            }
            // Check if quantity is valid
            else if (textQuantity.getText().equals("")) {
                JOptionPane.showMessageDialog(btnNewOrder, "Introduceti o cantitate valida!");
            } else {
                int availableStock = Integer.parseInt(productsData[productTable.getSelectedRow()][3]);
                int productID = Integer.parseInt(productsData[productTable.getSelectedRow()][0]);
                int clientID = Integer.parseInt(clientsData[clientTable.getSelectedRow()][0]);
                // Check if there is enough stock
                if (availableStock < Integer.parseInt(textQuantity.getText())) {
                    JOptionPane.showMessageDialog(btnNewOrder, "Stoc insuficient!");
                } else {
                    // Insert order into database
                    OrdersBLL ordersBLL = new OrdersBLL();
                    ProductBLL productBLL = new ProductBLL();
                    ClientBLL clientBLL = new ClientBLL();
                    Orders order = new Orders(clientID, productID, Integer.parseInt(textQuantity.getText()));
                    Orders o = ordersBLL.insertOrders(order);
                    // Get product and client information
                    Product p = productBLL.findProductById(productID);
                    Clients c = clientBLL.findClientById(clientID);
                    try {
                        // Create bill file
                        Bill bill=new Bill(c.getClientName(),p.getProductName(),p.getProductPrice(),c.getClientAddress());
                        insertBill(c.getClientName(),p.getProductName(),p.getProductPrice(),c.getClientAddress());
                        PrintWriter printWriter = new PrintWriter("T:\\sem2stuff\\TP\\PT2023_30222_Tecuci_Dragos_Assignment_3\\OrdersManagement" +
                                "\\bill" + o.getOrdersID() + ".txt");
                        printWriter.write("Comanda nr." + o.getOrdersID() + " s-a efectuat cu succes!\n\n");
                        printWriter.write("Client: " + c.getClientName() + "; E-Mail: " + c.getClientEmail() + "\n\n");
                        printWriter.write("Total pentru plata: " + p.getProductPrice() * Integer.parseInt(textQuantity.getText())+" Lei");
                        printWriter.close();
                        JOptionPane.showMessageDialog(btnNewOrder, "Comanda a fost salvata cu succes!");
                        p.setProductStock(p.getProductStock() - o.getQuantity());
                        productBLL.updateProduct(p);
                        frame.dispose();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}