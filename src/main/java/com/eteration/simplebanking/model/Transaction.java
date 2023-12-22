package com.eteration.simplebanking.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

import static java.time.LocalTime.now;

// This class is a place holder you can change the complete implementation
@Entity
@Getter
@Setter
@Table(name = "Transaction")
public abstract class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    public Date date;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;


    public Transaction(Double amount) {
        this.date = new Date();
        this.amount = amount;
    }

    public Transaction(Double amount, Account account) {
        this.date = new Date();
        this.amount = amount;
        this.account = account;
    }

    public Transaction() {

    }

    public abstract void process(Account account) throws InsufficientBalanceException;
}
