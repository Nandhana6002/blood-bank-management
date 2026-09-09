package com.bloodbank.auth;

import com.bloodbank.dashboard.MainFrame;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private AuthenticationService authenticationService;
    private MainFrame mainFrame;

    public LoginPanel(
            AuthenticationService authenticationService,
            MainFrame mainFrame) {

        this.authenticationService = authenticationService;
        this.mainFrame = mainFrame;

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel =
                new JLabel("Blood Bank Management System");

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        JLabel usernameLabel =
                new JLabel("Username:");

        JLabel passwordLabel =
                new JLabel("Password:");

        usernameField =
                new JTextField(15);

        passwordField =
                new JPasswordField(15);

        loginButton =
                new JButton("Login");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        add(titleLabel, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;

        add(usernameLabel, gbc);

        gbc.gridx = 1;

        add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        add(passwordLabel, gbc);

        gbc.gridx = 1;

        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;

        add(loginButton, gbc);

        loginButton.addActionListener(e -> login());
    }

    private void login() {

        String username =
                usernameField.getText();

        String password =
                new String(passwordField.getPassword());

        User user =
                authenticationService.login(
                        username,
                        password
                );

        if (user != null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Login successful!\nWelcome "
                            + user.getUsername()
            );

            mainFrame.showDashboard(user);

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid username or password.",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}