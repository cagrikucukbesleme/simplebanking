package com.eteration.simplebanking.model;


import com.eteration.simplebanking.enums.TransactionType;

import java.time.LocalDateTime;

public abstract class Transaction extends TransactionModel {
    TransactionType transactionType = null;
    double amount;

    Account account;

    LocalDateTime date = null;

    Transaction(Account account, TransactionType transactionType, double amount) {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }


    Transaction(TransactionType transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    Transaction(TransactionType transactionType) {
        this.transactionType = transactionType;
        this.date = LocalDateTime.now();
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transactionType=" + transactionType + ", amount=" + amount + ", account=" + account + ", date=" + date + '}';
    }
}
