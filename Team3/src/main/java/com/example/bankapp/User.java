package com.example.bankapp;

import org.codehaus.groovy.runtime.powerassert.SourceText;

import javax.xml.transform.Source;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


public class User {

    private String firstName;
    private String lastName;
    private String uuid;
    private byte pinHash[];
    private ArrayList<Account> accounts;

    public User(String firstName, String lastName, String pin, Bank theBank) {
        this.firstName = firstName;
        this.lastName = lastName;

        //store the pins MD5 hash

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("error, caught No such algoriths, hello check userclass");
            e.printStackTrace();
            System.exit(1);
        }

        // get a new, unique universal ID
        this.uuid = theBank.getNewUserUUID();
        this.accounts = new ArrayList<>();

        // print log message
        System.out.printf("new User %s, %s with ID %s created. \n", lastName, firstName, this.uuid);
    }

    public void addAccount(Account anAcct) {
        this.accounts.add(anAcct);
    }

    public String getUuid() {
        return this.uuid;
    }
}