package com.eteration.simplebanking.model;

import com.eteration.simplebanking.enums.TransactionType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author cagri
 */
@Entity
@Table(name = "Transaction")
public class TransactionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;


    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "amount")
    private double amount;

    @Column(name = "type", insertable = false, updatable = false)
    private TransactionType type;

    @Column(name = "approval_code")
    private String approvalCode = UUID.randomUUID().toString();

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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
