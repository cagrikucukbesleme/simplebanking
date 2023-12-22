package com.eteration.simplebanking.model;


import com.eteration.simplebanking.enums.TransactionType;

public class DepositTransaction extends Transaction {

    public DepositTransaction(Account account, double amount) {
        super(account, TransactionType.DEPOSIT_TRANSACTION, amount);
    }

    public DepositTransaction(double amount) {
        super(TransactionType.DEPOSIT_TRANSACTION, amount);
    }

    public DepositTransaction() {
        super(TransactionType.DEPOSIT_TRANSACTION);
    }
}
