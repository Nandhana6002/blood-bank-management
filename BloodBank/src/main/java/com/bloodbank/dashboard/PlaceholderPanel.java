package com.bloodbank.dashboard;

import javax.swing.*;
import java.awt.*;

public class PlaceholderPanel extends JPanel {

    public PlaceholderPanel(String message) {

        setLayout(new BorderLayout());

        JLabel label = new JLabel(
                message,
                SwingConstants.CENTER
        );

        label.setFont(
                new Font("Arial", Font.BOLD, 20)
        );

        add(label, BorderLayout.CENTER);
    }
}