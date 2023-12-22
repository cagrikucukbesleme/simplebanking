package com.eteration.simplebanking.model;


import com.eteration.simplebanking.enums.TransactionType;

public class DepositTransaction extends Transaction {

    public DepositTransaction(Account account, Object amount) {
        super(account, TransactionType.DEPOSIT_TRANSACTION, (Double) amount);
    }

    public DepositTransaction(Object amount) {
        super(TransactionType.DEPOSIT_TRANSACTION, (Double) amount);
    }

    public DepositTransaction() {
        super(TransactionType.DEPOSIT_TRANSACTION);
    }
}
