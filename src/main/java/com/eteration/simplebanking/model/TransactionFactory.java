package com.eteration.simplebanking.model;

import com.eteration.simplebanking.enums.TransactionType;

/**
 * @author cagri
 */
public class TransactionFactory {
    public TransactionFactory() {
    }

    public static Transaction buildTransaction(TransactionType type, Account account, Object amount) {
        Transaction transaction = null;

        switch (type) {
            case WITHDRAWAL_TRANSACTION:
                transaction = new WithdrawalTransaction(account, amount);
                break;

            case CHECK_TRANSACTION:
                transaction = new CheckTransaction(account, amount);
                break;

            case DEPOSIT_TRANSACTION:
                transaction = new DepositTransaction(account, amount);
                break;

            case PHONE_BILL_PAYMENT_TRANSACTION:
                transaction = new PhoneBillPaymentTransaction(account, amount);
                break;

        }

        return transaction;

    }
}
