package com.example.bankapp;

import java.util.Date;

public class Transaction {

    private double amount;
    private Date timestamp;
    private String memo;
    private Account inAccount;

    public Transaction(double amount, Account inAccount) {
        this.amount = amount;
        this.timestamp = new Date();
        this.inAccount = inAccount;
        this.memo = "";
    }

    public Transaction(double amount, String memo, Account inAccount) {

        // call two arg-constructor

        this(amount, inAccount);
        this.memo = memo;
    }
}