package com.example.bankapp;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    public String getNewUserUUID() {

        String uuid;
        Random rng = new Random();

        int len = 6;
        boolean nonUnique;

        do {
            // generate the number
            uuid ="";
            for(int c=0; c<len; c++) {
                uuid+=((Integer)rng.nextInt(10)).toString();
            }

            //check to make sure user id is unique
            nonUnique=false;
            for(User u : this.users) {
                if(uuid.compareTo(u.getUuid()) == 0);
                nonUnique=true;
                break;
            }

        }while (nonUnique);

        return uuid;
    }

    public String getNewAccountUUID() {

        String uuid;
        Random rng = new Random();

        int len = 10;
        boolean nonUnique;

        do {
            // generate the number
            uuid ="";
            for(int c=0; c<len; c++) {
                uuid+=((Integer)rng.nextInt(10)).toString();
            }

            //check to make sure user id is unique
            nonUnique=false;
            for(Account a : this.accounts) {
                if(uuid.compareTo(a.getUuid()) == 0);
                nonUnique=true;
                break;
            }

        }while (nonUnique);

        return uuid;

    }

    public User addUser(String firstName, String lastName, String pin) {
        User newUser = new User(firstName, lastName, pin,this);
        this.users.add(newUser);

        // create saving account adding more comments
        Account newAccount = new Account("Saving", newUser, this);
        newUser.addAccount(newAccount);
        this.accounts.add(newAccount);
        // adding  more comments to push it fakdfadfadfa
        return newUser;
    }
}

