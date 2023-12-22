package com.eteration.simplebanking.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

// This class is a place holder you can change the complete implementation
@Entity
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    @NonNull
    private String accountNumber;
    private String owner;
    private Double balance=0.0;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Account(String owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
    }
    public Account(){

    }


    public void post(Transaction transaction) throws InsufficientBalanceException {
        if (transaction instanceof WithdrawalTransaction) {
            withdraw(transaction.getAmount());
        } else if (transaction instanceof DepositTransaction) {
            deposit(transaction.getAmount());
        }
        transactions.add(transaction);
    }

    public void deposit(int amount) {
        this.deposit(Double.valueOf(amount));
    }
    public void deposit(Double amount) {
        this.balance = this.balance + amount;
    }

    public void withdraw(int amount) throws InsufficientBalanceException {
        this.withdraw(Double.valueOf(amount));
    }
    public void withdraw(Double i) throws InsufficientBalanceException {
        if (this.balance < i) {
            throw new InsufficientBalanceException();
        }
        this.balance = this.balance - i;
    }

}
