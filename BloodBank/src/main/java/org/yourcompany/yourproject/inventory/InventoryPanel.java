package org.yourcompany.yourproject.inventory;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.List;

public class InventoryPanel extends JPanel{
    private JTable table;
    private InventoryManager inventoryManager;
    private DefaultTableModel tableModel;
    private JComboBox<BloodGroup> bloodGroupCombo;
    private JComboBox<BloodComponent> bloodComponentCombo;
    private JTextField phoneField;
    private JTextField collectionDateField;
    
    public InventoryPanel(){
        inventoryManager = new InventoryManager();
        setLayout(new BorderLayout());

        String[] columns = {"Unit ID", "Blood Group", "Blood Component", "Donor Phone", "Collection Date", "Expiration Date", "Status"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        


    }

}