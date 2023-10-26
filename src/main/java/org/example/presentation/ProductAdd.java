package org.example.presentation;

import org.example.businessLayer.ProductBLL;
import org.example.Model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductAdd implements ActionListener {

    private JFrame frame = new JFrame("ProductAdd");
    private JPanel panel = new JPanel();

    private JTextField textName = new JTextField();
    private JTextField textPrice = new JTextField();
    private JTextField textStock = new JTextField();
    private JButton btnAdd = new JButton("Adauga");

    public ProductAdd() {
        JLabel labelTitle = new JLabel("Introduceti noul produs:");
        JLabel labelName = new JLabel("Nume:");
        JLabel labelPrice = new JLabel("Pret:");
        JLabel labelStock = new JLabel("Stoc:");
        panel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(labelTitle, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(labelName, constraints);

        constraints.gridx = 1;
        panel.add(textName, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(labelPrice, constraints);

        constraints.gridx = 1;
        panel.add(textPrice, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(labelStock, constraints);

        constraints.gridx = 1;
        panel.add(textStock, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(btnAdd, constraints);

        btnAdd.addActionListener(this);
        btnAdd.setContentAreaFilled(false);
        btnAdd.setFocusPainted(false);

        frame.add(panel);
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null); // centers the frame on screen
        frame.setVisible(true);
    }

    /**
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            if (textPrice.getText().equals("") || textName.getText().equals("") || textStock.getText().equals("")) {
                JOptionPane.showMessageDialog(btnAdd, "Completati toate campurile");
            } else if (Integer.parseInt(textPrice.getText()) <= 0) {
                JOptionPane.showMessageDialog(btnAdd, "Pretul produsului nu poate fi negativ");
            } else if (Integer.parseInt(textStock.getText()) <= 0) {
                JOptionPane.showMessageDialog(btnAdd, "Stocul produsului trebuie sa fie mai mare >0");
            } else {
                JOptionPane.showMessageDialog(btnAdd, "Produsul a fost adaugat");
                Product product = new Product(textName.getText(), Integer.parseInt(textPrice.getText()), Integer.parseInt(textStock.getText()));
                ProductBLL productBLL = new ProductBLL();
                productBLL.insertProduct(product);
                frame.dispose();
            }
        }
    }
}
