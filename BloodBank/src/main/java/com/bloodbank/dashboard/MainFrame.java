package com.bloodbank.dashboard;

import com.bloodbank.auth.AuthenticationService;
import com.bloodbank.auth.InMemoryUserRepository;
import com.bloodbank.auth.LoginPanel;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {

    public MainFrame() {

        setTitle("Blood Bank Management System");

        setSize(600, 400);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        InMemoryUserRepository userRepository =
                new InMemoryUserRepository();

        AuthenticationService authenticationService =
                new AuthenticationService(userRepository);

        LoginPanel loginPanel =
                new LoginPanel(authenticationService);

        add(loginPanel);

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
    }
}