package com.eteration.simplebanking.model;

import com.eteration.simplebanking.enums.TransactionType;

/**
 * @author cagri
 */
public class PhoneBillPaymentTransaction extends Transaction {

    public PhoneBillPaymentTransaction(Account account, Object amount) {
        super(account, TransactionType.PHONE_BILL_PAYMENT_TRANSACTION, (Double) amount);
    }

    public PhoneBillPaymentTransaction(Double amount) {
        super(TransactionType.PHONE_BILL_PAYMENT_TRANSACTION, amount);
    }

    public PhoneBillPaymentTransaction() {
        super(TransactionType.PHONE_BILL_PAYMENT_TRANSACTION);
    }

}
