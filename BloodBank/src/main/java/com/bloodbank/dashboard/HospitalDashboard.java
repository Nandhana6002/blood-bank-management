package com.bloodbank.dashboard;

import javax.swing.*;
import java.awt.*;

public class HospitalDashboard extends JPanel {

    private MainFrame mainFrame;

    public HospitalDashboard(MainFrame mainFrame) {

        this.mainFrame = mainFrame;

        setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel(
                "Hospital Dashboard",
                SwingConstants.CENTER
        );

        title.setFont(
                new Font("Arial", Font.BOLD, 24)
        );

        add(title, BorderLayout.NORTH);

        JPanel summaryPanel =
                new JPanel(new GridLayout(1, 2, 10, 10));

        JLabel inventoryLabel =
                new JLabel(
                        "<html><center>Available Blood Units<br>0</center></html>",
                        SwingConstants.CENTER
                );

        JLabel requestLabel =
                new JLabel(
                        "<html><center>My Requests<br>0</center></html>",
                        SwingConstants.CENTER
                );

        summaryPanel.add(inventoryLabel);
        summaryPanel.add(requestLabel);

        add(summaryPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton inventoryButton =
                new JButton("View Inventory");

        JButton requestButton =
                new JButton("Request Blood");

        buttonPanel.add(inventoryButton);
        buttonPanel.add(requestButton);

        add(buttonPanel, BorderLayout.SOUTH);

        inventoryButton.addActionListener(e ->
                mainFrame.showScreen("INVENTORY")
        );

        requestButton.addActionListener(e ->
                mainFrame.showScreen("REQUESTS")
        );
    }
}