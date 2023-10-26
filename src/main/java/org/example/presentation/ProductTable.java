package org.example.presentation;

import org.example.businessLayer.ProductBLL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ProductTable {
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("Products");
    private JTable table=new JTable();

    public JTable getTable() {
        return table;
    }

    /**
     *
     * @param showFrame
     */
    ProductTable(boolean showFrame) {
        ProductBLL productBLL = new ProductBLL();

        DefaultTableModel defaultTableModel = new DefaultTableModel(productBLL.getListOfProducts(), productBLL.getFieldNames()){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setModel(defaultTableModel);

        table.getTableHeader().setReorderingAllowed(false); // disable column reordering
        if(showFrame){
       show();}
    }
    private void show()
    {
        // Set the preferred width for each column
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(200); // ID column
        columnModel.getColumn(1).setPreferredWidth(400); // Name column
        columnModel.getColumn(2).setPreferredWidth(300); // Address column
        columnModel.getColumn(3).setPreferredWidth(300); // Email column
        panel.add(new JScrollPane(table));
        frame.setContentPane(panel);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null); // centers the frame on screen
        frame.setVisible(true);
    }

}
