package org.example.presentation;

import org.example.businessLayer.OrdersBLL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class OrdersTable {
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("Orders");
    private JTable table=new JTable();

    public JTable getTable() {
        return table;
    }

    OrdersTable() {
        OrdersBLL ordersBLL = new OrdersBLL();

        DefaultTableModel defaultTableModel = new DefaultTableModel(ordersBLL.getListOfOrders(), ordersBLL.getFieldNames()){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setModel(defaultTableModel);

        table.getTableHeader().setReorderingAllowed(false); // disable column reordering
        // Set the preferred width for each column
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(200); // ID column
        columnModel.getColumn(1).setPreferredWidth(200); // Name column
        columnModel.getColumn(2).setPreferredWidth(300); // Address column
        columnModel.getColumn(3).setPreferredWidth(400); // Email column
        panel.add(new JScrollPane(table));
        frame.setContentPane(panel);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null); // centers the frame on screen
        frame.setVisible(true);

    }

}
