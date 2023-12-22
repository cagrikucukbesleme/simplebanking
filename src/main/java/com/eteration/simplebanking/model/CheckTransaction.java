package com.eteration.simplebanking.model;

/**
 * @author cagri
 */
public class CheckTransaction extends Transaction {

    public CheckTransaction(Account account, Object amount) {
        super(account, TransactionType.CHECK_TRANSACTION, (Double) amount);
    }

    public CheckTransaction(Double amount) {
        super(TransactionType.CHECK_TRANSACTION, amount);
    }

    public CheckTransaction() {
        super(TransactionType.CHECK_TRANSACTION);
    }

    @Override
    void construct() {

    }
}
