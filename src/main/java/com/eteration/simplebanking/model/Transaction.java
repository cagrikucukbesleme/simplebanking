package com.eteration.simplebanking.model;


import java.time.LocalDateTime;

public abstract class Transaction {
    TransactionType transactionType = null;
    Double amount = null;

    Account account = null;

    LocalDateTime date = null;

    Transaction(Account account, TransactionType transactionType, Double amount) {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    Transaction(TransactionType transactionType, Double amount) {
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

    @Override
    public String toString() {
        return "Transaction{" + "transactionType=" + transactionType + ", amount=" + amount + ", date=" + date + '}';
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    abstract void construct();
}
