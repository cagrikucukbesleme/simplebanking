package com.eteration.simplebanking.model;

/**
 * @author cagri
 */
public class PhoneBillPaymentTransaction extends Transaction {

    public PhoneBillPaymentTransaction(Account account, Object amount) {
        super(account, TransactionType.PHONE_BILL_PAYMENT_TRANSACTION, (Double) amount);
        construct();
    }

    public PhoneBillPaymentTransaction(Double amount) {
        super(TransactionType.PHONE_BILL_PAYMENT_TRANSACTION, amount);
        construct();
    }
    public PhoneBillPaymentTransaction() {
        super(TransactionType.PHONE_BILL_PAYMENT_TRANSACTION);
        construct();
    }

    @Override
    void construct() {

    }





    /*
    @Override
    public void process(Account account) throws InsufficientBalanceException {

    }

     */
}
