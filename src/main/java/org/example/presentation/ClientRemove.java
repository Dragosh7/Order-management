package org.example.presentation;

import org.example.businessLayer.ClientBLL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientRemove implements ActionListener {
    private JFrame frame = new JFrame("Remove client");
    private JPanel panel = new JPanel();
    private JLabel labelTitle = new JLabel("Introduceti un ID valid de client!");
    private JTextField textID = new JTextField();
    private JButton btnDelete = new JButton("Sterge");

    public ClientRemove() {
        labelTitle.setBounds(50, 25, 300, 30);
        textID.setBounds(50, 60, 300, 30);
        btnDelete.setBounds(50, 100, 300, 30);

        labelTitle.setFont(new Font("Arial", Font.BOLD, 14));
        btnDelete.setFocusPainted(false);
        btnDelete.setContentAreaFilled(false);

        btnDelete.addActionListener(this);

        panel.add(labelTitle);
        panel.add(textID);
        panel.add(btnDelete);

        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    /**
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDelete) {
            if (textID.getText().equals("")) {
                JOptionPane.showMessageDialog(btnDelete, "ID invalid");
            } else {
                ClientBLL clientBLL = new ClientBLL();
                clientBLL.deleteClient(Integer.parseInt(textID.getText()));
                JOptionPane.showMessageDialog(btnDelete, "Clientul a fost sters!");
                frame.dispose();
            }
        }
    }
}
