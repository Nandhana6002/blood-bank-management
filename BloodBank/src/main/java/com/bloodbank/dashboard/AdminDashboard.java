package com.bloodbank.dashboard;

import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JPanel {

    public AdminDashboard() {

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Admin Dashboard", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel message = new JLabel(
                "Welcome Admin! You can manage inventory and donations.",
                SwingConstants.CENTER
        );

        add(title, BorderLayout.NORTH);
        add(message, BorderLayout.CENTER);
    }
}