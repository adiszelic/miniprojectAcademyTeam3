package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    String name;
    List<com.example.demo.User> users;

    public Bank() {
        this.name=name;
        this.users = new ArrayList<>();
    }

    public void addUser(com.example.demo.User newUser) {
        this.users.add(newUser);
    }

    public List<com.example.demo.User> getUsers() {
        return users;
    }
}
