package com.example.bankapp;

import java.util.ArrayList;

public class Account {

    private String name;
   // private double balance; han hanterar i transactions
    private String uuid;
    private User holder;
    private ArrayList<Transaction> transactions;

    public Account(String name, User holder, Bank theBank) {
        this.name = name;
        this.holder = holder;
        // get new account UUID,

        this.uuid= theBank.getNewAccountUUID();

        // intialize transactions
        this.transactions = new ArrayList<>();

        // add to holder and bank lists
        holder.addAccount(this);
        theBank.addAccount(this);

    }
}
