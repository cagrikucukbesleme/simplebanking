package com.eteration.simplebanking.model;


public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction(Account account, Object amount) {
        super(account, TransactionType.WITHDRAWAL_TRANSACTION, (Double) amount);
        construct();
    }

    public WithdrawalTransaction(Object amount) {
        super(TransactionType.WITHDRAWAL_TRANSACTION, (Double) amount);
        construct();
    }

    public WithdrawalTransaction() {
        super(TransactionType.WITHDRAWAL_TRANSACTION);
        construct();
    }

    @Override
    void construct() {

    }
}


