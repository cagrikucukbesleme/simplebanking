package com.eteration.simplebanking.model;


import com.eteration.simplebanking.enums.TransactionType;

public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction(Account account, double amount) {
        super(account, TransactionType.WITHDRAWAL_TRANSACTION, amount);
    }

    public WithdrawalTransaction(double amount) {
        super(TransactionType.WITHDRAWAL_TRANSACTION, amount);
    }

    public WithdrawalTransaction() {
        super(TransactionType.WITHDRAWAL_TRANSACTION);
    }
}


