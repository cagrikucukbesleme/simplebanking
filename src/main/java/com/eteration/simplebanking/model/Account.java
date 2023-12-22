package com.eteration.simplebanking.model;


import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;
    @NonNull
    private String accountNumber;
    private String owner;
    private Double balance = 0.0;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<TransactionModel> transactions;

    public Account(String owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
    }

    public Account() {

    }

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

    public List<TransactionModel> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionModel> transactions) {
        this.transactions = transactions;
    }

    public void post(Transaction transaction) throws InsufficientBalanceException {
        if (transaction instanceof WithdrawalTransaction) {
            withdraw(transaction.getAmount());
        } else if (transaction instanceof DepositTransaction) {
            deposit(transaction.getAmount());
        }
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setAmount(transaction.getAmount());
        transactionModel.setAccount(transaction.getAccount());
        transactionModel.setDate(transaction.getDate());
        transactionModel.setType(transaction.getTransactionType());
        transactions.add(transactionModel);
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

    public void withdraw(Double amount) throws InsufficientBalanceException {
        if (this.balance < amount) {
            throw new InsufficientBalanceException();
        }
        this.balance = this.balance - amount;
    }

}
