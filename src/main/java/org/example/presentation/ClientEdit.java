package org.example.presentation;

import org.example.businessLayer.ClientBLL;
import org.example.Model.Clients;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientEdit implements ActionListener {
    private JFrame frame = new JFrame("ClientEdit");
    private JPanel panel = new JPanel();
    private JTextField textSearch = new JTextField();
    private JTextField textName = new JTextField();
    private JTextField textAddress = new JTextField();
    private JTextField textEmail = new JTextField();
    private JButton btnSearch = new JButton("Cauta");
    private JButton btnEdit = new JButton("Modifica");

    public ClientEdit() {

        JLabel labelName = new JLabel("Nume:");
        JLabel labelAddress = new JLabel("Adresa:");
        JLabel labelEmail = new JLabel("Email:");

        JLabel labelSearch = new JLabel("Introduceti ID-ul client-ului");

        btnEdit.setFocusPainted(false);
        btnEdit.setContentAreaFilled(false);
        btnSearch.setFocusPainted(false);
        btnSearch.setContentAreaFilled(false);

        labelSearch.setBounds(30, 30, 300, 30);
        textSearch.setBounds(30, 65, 350, 30);
        labelName.setBounds(30, 120, 150, 30);
        textName.setBounds(30, 155, 350, 30);
        labelAddress.setBounds(30, 190, 150, 30);
        textAddress.setBounds(30, 225, 350, 30);
        labelEmail.setBounds(30, 260, 150, 30);
        textEmail.setBounds(30, 295, 350, 30);
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
        panel.add(textAddress);
        panel.add(textEmail);
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
                JOptionPane.showMessageDialog(btnSearch, "Introduceti un ID de client!");
            } else {
                ClientBLL clientBLL = new ClientBLL();
                Clients c = clientBLL.findClientById(Integer.parseInt(textSearch.getText()));
                textName.setText(c.getClientName());
                textAddress.setText(c.getClientAddress());
                textEmail.setText(c.getClientEmail());
            }
        }
        if (e.getSource() == btnEdit) {
            if (textSearch.getText().equals("") || textName.getText().equals("") || textAddress.getText().equals("") || textEmail.getText().equals("")) {
                JOptionPane.showMessageDialog(btnEdit, "Toate campurile trebuie completate");
            } else if (textAddress.getText().equals("") || textName.getText().equals("") || textEmail.getText().equals("")) {
                JOptionPane.showMessageDialog(btnEdit, "Toate campurile trebuie completate!");
            } else if (!textEmail.getText().contains("@") || !textEmail.getText().contains(".")) {
                JOptionPane.showMessageDialog(btnEdit, "E-Mail invalid");
            } else {
                JOptionPane.showMessageDialog(btnEdit, "Datele clientului au fost modificate");
                ClientBLL clientBLL = new ClientBLL();
                Clients c = clientBLL.findClientById(Integer.parseInt(textSearch.getText()));
                c.setClientName(textName.getText());
                c.setClientAddress(textAddress.getText());
                c.setClientEmail(textEmail.getText());
                clientBLL.updateClient(c);
                frame.dispose();
            }
        }
    }
}
