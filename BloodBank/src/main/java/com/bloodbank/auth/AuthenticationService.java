package com.bloodbank.auth;

public class AuthenticationService {

    private InMemoryUserRepository userRepository;

    public AuthenticationService(InMemoryUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String username, String password) {

        User user = userRepository.findById(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}