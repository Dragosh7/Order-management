package org.example.presentation;

import org.example.businessLayer.ClientBLL;
import org.example.Model.Clients;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientAdd implements ActionListener {
    private JPanel panel = new JPanel();

    private JFrame frame = new JFrame("ClientAdd");

    private JTextField textName = new JTextField();
    private JTextField textAddress = new JTextField();
    private JTextField textEmail = new JTextField();
    private JButton btnAdd = new JButton("Adauga");

    public ClientAdd() {
        JLabel labelTitle = new JLabel("Datele clientului:");
        JLabel labelName = new JLabel("Nume:");
        JLabel labelAddress = new JLabel("Adresa:");
        JLabel labelEmail = new JLabel("E-mail:");
        // Set up the panel
        panel.setLayout(new GridLayout(4, 2));
        panel.add(labelTitle);
        panel.add(new JLabel(""));
        panel.add(labelName);
        panel.add(textName);
        panel.add(labelAddress);
        panel.add(textAddress);
        panel.add(labelEmail);
        panel.add(textEmail);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add action listener to the button
        btnAdd.addActionListener(this);
        btnAdd.setContentAreaFilled(false);
        btnAdd.setFocusPainted(false);

        // Add components to the frame
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.add(btnAdd, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        panel.setLayout(null);
        frame.setSize(300, 250);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            if (textAddress.getText().equals("") || textName.getText().equals("") || textEmail.getText().equals("")) {
                JOptionPane.showMessageDialog(btnAdd, "Nu s-au completat toate campurile");
            } else if (!textEmail.getText().contains("@") || !textEmail.getText().contains(".")) {
                JOptionPane.showMessageDialog(btnAdd, "Invalid E-Mail!");
            } else {
                JOptionPane.showMessageDialog(btnAdd, "Clientul a fost adaugat");
                Clients client = new Clients(textName.getText(), textAddress.getText(), textEmail.getText());
                ClientBLL clientBLL = new ClientBLL();
                clientBLL.insertClient(client);
                frame.dispose();
            }
        }

    }
}
