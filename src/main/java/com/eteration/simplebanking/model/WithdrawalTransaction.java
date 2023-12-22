package com.eteration.simplebanking.model;


import com.eteration.simplebanking.enums.TransactionType;

public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction(Account account, Object amount) {
        super(account, TransactionType.WITHDRAWAL_TRANSACTION, (Double) amount);
    }

    public WithdrawalTransaction(Object amount) {
        super(TransactionType.WITHDRAWAL_TRANSACTION, (Double) amount);
    }

    public WithdrawalTransaction() {
        super(TransactionType.WITHDRAWAL_TRANSACTION);
    }
}


