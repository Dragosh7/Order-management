package org.example.presentation;

import org.example.businessLayer.ProductBLL;
import org.example.Model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductEdit implements ActionListener {
    private JFrame frame = new JFrame("ProductEdit");
    private JPanel panel = new JPanel();
    private JTextField textSearch = new JTextField();
    private JTextField textName = new JTextField();
    private JTextField textPrice = new JTextField();
    private JTextField textStock = new JTextField();
    private JButton btnSearch = new JButton("Cauta");
    private JButton btnEdit = new JButton("Modifica");

    public ProductEdit() {

        JLabel labelName = new JLabel("Nume:");
        JLabel labelAddress = new JLabel("Pret:");
        JLabel labelEmail = new JLabel("Stoc:");

        JLabel labelSearch = new JLabel("Introduceti ID-ul produs-ului");

        btnEdit.setFocusPainted(false);
        btnEdit.setContentAreaFilled(false);
        btnSearch.setFocusPainted(false);
        btnSearch.setContentAreaFilled(false);

        labelSearch.setBounds(30, 30, 300, 30);
        textSearch.setBounds(30, 65, 350, 30);
        labelName.setBounds(30, 120, 150, 30);
        textName.setBounds(30, 155, 350, 30);
        labelAddress.setBounds(30, 190, 150, 30);
        textPrice.setBounds(30, 225, 350, 30);
        labelEmail.setBounds(30, 260, 150, 30);
        textStock.setBounds(30, 295, 350, 30);
        btnSearch.setBounds(390, 65, 90, 30);
        btnEdit.setBounds(130, 350, 250, 30);

        btnEdit.setFocusPainted(false);
        btnEdit.setContentAreaFilled(false);
        btnSearch.setFocusPainted(false);
        btnSearch.setContentAreaFilled(false);

        btnEdit.addActionListener(this);
        btnSearch.addActionListener(this);

        panel.add(labelName);
        panel.add(labelAddress);
        panel.add(labelEmail);
        panel.add(labelSearch);
        panel.add(textSearch);
        panel.add(textName);
        panel.add(textPrice);
        panel.add(textStock);
        panel.add(btnEdit);
        panel.add(btnSearch);

        panel.setLayout(null);
        frame.setSize(500, 450);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(panel);


    }

    /**
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            if (textSearch.getText().equals("")) {
                JOptionPane.showMessageDialog(btnSearch, "Introduceti ID-ul produsului");
            } else {
                ProductBLL productBLL = new ProductBLL();
                Product p = productBLL.findProductById(Integer.parseInt(textSearch.getText()));
                textName.setText(p.getProductName());
                textPrice.setText(String.valueOf(p.getProductPrice()));
                textStock.setText(String.valueOf(p.getProductStock()));
            }
        }
        if (e.getSource() == btnEdit) {
            if (textSearch.getText().equals("") || textName.getText().equals("") || textPrice.getText().equals("") || textStock.getText().equals("")) {
                JOptionPane.showMessageDialog(btnEdit, "Completati toate campurile!");
            } else if (Integer.parseInt(textPrice.getText()) <= 0) {
                JOptionPane.showMessageDialog(btnEdit, "Pretul produsului nu poate fi negativ");
            } else if (Integer.parseInt(textStock.getText()) <= 0) {
                JOptionPane.showMessageDialog(btnEdit, "Stocul produsului trebuie sa fie mai mare >0");
            } else {
                JOptionPane.showMessageDialog(btnEdit, "Datele produsului au fost modificate");
                ProductBLL productBLL = new ProductBLL();
                Product p = productBLL.findProductById(Integer.parseInt(textSearch.getText()));
                p.setProductName(textName.getText());
                p.setProductPrice(Integer.parseInt(textPrice.getText()));
                p.setProductStock(Integer.parseInt(textStock.getText()));
                productBLL.updateProduct(p);
                frame.dispose();
            }
        }
    }
}
