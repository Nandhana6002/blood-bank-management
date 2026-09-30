package com.bloodbank.auth;

import com.bloodbank.common.Repository;
import com.bloodbank.common.Role;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements Repository<User, String> {

    private List<User> users = new ArrayList<>();

    // Constructor
    public InMemoryUserRepository() {
        users.add(new User("admin", "admin123", Role.ADMIN));
        users.add(new User("hospital", "hospital123", Role.HOSPITAL));
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public User findById(String id) {
        for (User user : users) {
            if (user.getUsername().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void update(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(user.getUsername())) {
                users.set(i, user);
                return;
            }
        }
    }

    @Override
    public void delete(String id) {
        users.removeIf(user -> user.getUsername().equals(id));
    }
}