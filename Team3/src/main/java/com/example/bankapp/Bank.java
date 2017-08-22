package com.example.bankapp;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    public String getNewUserUUID() {
        // inits

        String uuid;
        Random rng = new Random();
        int len = 6;
        boolean nonUnique = false;

        do {
            //generate the number
            uuid = "";
            for (int c = 0; c < len; c++) {
                uuid += ((Integer) rng.nextInt(10)).toString();
            }
            //check to make sure the number is unique

            for (User u : this.users) {
                if (uuid.compareTo(u.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);


        return uuid;


    }

    public String getNewAccountUUID() {
        // inits

        String uuid;
        Random rng = new Random();
        int len = 10;
        boolean nonUnique = false;

        do {
            //generate the number
            uuid = "";
            for (int c = 0; c < len; c++) {
                uuid += ((Integer) rng.nextInt(10)).toString();
            }
            //check to make sure the number is unique

            for (Account a : this.accounts) {
                if (uuid.compareTo(a.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);


        return uuid;

    }


//    public User addUser(String firstName, String lastName, String pin) {
//
//        //create a new User object and add it to the list
//        User newUser = new User(firstName, lastName, pin, this);  {
//            this.users.add(newUser);
//
//            // Create different accounts for the user. this is for now a savings account
//            Account newAccount = new Account("Savings", newUser, this);
//            newUser.addAccount(newAccount);
//            this.accounts.add(newAccount);
//        }
}




