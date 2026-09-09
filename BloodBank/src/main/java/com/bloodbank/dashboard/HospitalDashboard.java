package com.bloodbank.dashboard;

import javax.swing.*;
import java.awt.*;

public class HospitalDashboard extends JPanel {

    public HospitalDashboard() {

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Hospital Dashboard", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel message = new JLabel(
                "Welcome Hospital! You can view inventory and request blood.",
                SwingConstants.CENTER
        );

        add(title, BorderLayout.NORTH);
        add(message, BorderLayout.CENTER);
    }
}