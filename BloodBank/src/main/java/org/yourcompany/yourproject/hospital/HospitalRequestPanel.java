package org.yourcompany.yourproject.hospital;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class HospitalRequestPanel extends JFrame {
    private HospitalRequestRepository repository;
    DefaultTableModel tableModel;
    JTable requestTable;

    public HospitalRequestPanel() {
        repository = new InMemoryHospitalRequestRepository();

        setTitle("Blood Bank Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Title
        JLabel title = new JLabel("Hospital Blood Request");
        JPanel alertPanel = new JPanel();
        alertPanel.setLayout(new BoxLayout(alertPanel, BoxLayout.Y_AXIS));

        JLabel alertTitle = new JLabel("LOW STOCK ALERT");
        alertTitle.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel alertMessage = new JLabel("O+ : 2 units remaining");

        alertPanel.add(alertTitle);
        alertPanel.add(alertMessage);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        topPanel.add(title);
        topPanel.add(alertPanel);

        add(topPanel, BorderLayout.NORTH);


        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        JLabel hospitalLabel = new JLabel("Hospital Name:");
        JTextField hospitalField = new JTextField();

        JLabel patientLabel = new JLabel("Patient Name:");
        JTextField patientField = new JTextField();

        JLabel bloodLabel = new JLabel("Blood Group:");

        String[] bloodGroups = {
            "A+", "A-", "B+", "B-",
            "AB+", "AB-", "O+", "O-"
        };

        JComboBox<String> bloodGroupBox =
                new JComboBox<>(bloodGroups);

        JLabel unitsLabel = new JLabel("Units Required:");
        JTextField unitsField = new JTextField();

        JLabel urgencyLabel = new JLabel("Urgency:");

        String[] urgencyOptions = {
            "Normal", "Urgent", "Emergency"
        };

        JComboBox<String> urgencyBox =
                new JComboBox<>(urgencyOptions);


        formPanel.add(hospitalLabel);
        formPanel.add(hospitalField);

        formPanel.add(patientLabel);
        formPanel.add(patientField);

        formPanel.add(bloodLabel);
        formPanel.add(bloodGroupBox);

        formPanel.add(unitsLabel);
        formPanel.add(unitsField);

        formPanel.add(urgencyLabel);
        formPanel.add(urgencyBox);


        // Submit button
        JButton submitButton = new JButton("Submit Request");
        JButton clearButton = new JButton("Clear Form");
        clearButton.addActionListener(e -> {
            hospitalField.setText("");
            patientField.setText("");
            unitsField.setText("");
            bloodGroupBox.setSelectedIndex(0);
            urgencyBox.setSelectedIndex(0);
        });
        JButton approveButton = new JButton("Approve Request");
        JButton rejectButton = new JButton("Reject Request");
        submitButton.addActionListener(e -> {

            String hospitalName = hospitalField.getText();
            String patientName = patientField.getText();
            String bloodGroup = (String) bloodGroupBox.getSelectedItem();
            String units = unitsField.getText();
            String urgency = (String) urgencyBox.getSelectedItem();
           if (hospitalName.trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter the hospital name."
                );
                return;
            }

            if (patientName.trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter the patient name."
                );
                return;
            }

            if (units.trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter the number of units."
                );
                return;
            }

            int unitCount;

            try {
                unitCount = Integer.parseInt(units);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                    this,
                    "Units must be a number."
                );
                return;
            }

            if (unitCount <= 0) {
                JOptionPane.showMessageDialog(
                    this,
                    "Units must be greater than 0."
                );
                return;
            }
            String requestId = "R" + (tableModel.getRowCount() + 1);
            HospitalRequest request = new HospitalRequest(
                requestId,
                hospitalName,
                patientName,
                bloodGroup,
                unitCount,
                urgency
            );
            repository.save(request);
            tableModel.addRow(new Object[]{
                requestId,
                hospitalName,
                patientName,
                bloodGroup,
                units,
                urgency,
                "Pending"
            });

            JOptionPane.showMessageDialog(
                this,
                "Request submitted successfully!\n\n" +
                "Hospital: " + hospitalName + "\n" +
                "Patient: " + patientName + "\n" +
                "Blood Group: " + bloodGroup + "\n" +
                "Units: " + units + "\n" +
                "Urgency: " + urgency
            );
        });
        
        approveButton.addActionListener(e -> {

            int selectedRow = requestTable.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please select a request first."
                );
                return;
            }

            String requestId = (String) tableModel.getValueAt(selectedRow, 0);

            HospitalRequest request = repository.findById(requestId);

            if (request != null) {
                request.setStatus("Approved");
                repository.update(request);

                tableModel.setValueAt("Approved", selectedRow, 6);
            }
        });
        rejectButton.addActionListener(e -> {

            int selectedRow = requestTable.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please select a request first."
                );
                return;
            }

            String requestId = (String) tableModel.getValueAt(selectedRow, 0);

            HospitalRequest request = repository.findById(requestId);

            if (request != null) {
                request.setStatus("Rejected");
                repository.update(request);

                tableModel.setValueAt("Rejected", selectedRow, 6);
            }
        });
        JPanel bottomPanel = new JPanel();

        bottomPanel.add(submitButton);
        bottomPanel.add(clearButton);
        bottomPanel.add(approveButton);
        bottomPanel.add(rejectButton);
        String[] columns = {
            "ID", "Hospital", "Patient", "Blood Group",
            "Units", "Urgency", "Status"
        };

        tableModel = new DefaultTableModel(columns, 0);

        requestTable = new JTable(tableModel);

        JScrollPane tableScrollPane = new JScrollPane(requestTable);


        // Main panel
        JPanel centerPanel = new JPanel(new BorderLayout(20, 20));

        centerPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        30, 100, 30, 100
                )
        );

        centerPanel.add(formPanel, BorderLayout.NORTH);
        centerPanel.add(tableScrollPane, BorderLayout.CENTER);
        centerPanel.add(bottomPanel, BorderLayout.SOUTH);


        add(centerPanel, BorderLayout.CENTER);
    }


    public static void main(String[] args) {

        new HospitalRequestPanel().setVisible(true);

    }
}