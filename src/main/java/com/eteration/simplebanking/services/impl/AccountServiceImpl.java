package com.eteration.simplebanking.services.impl;

import com.eteration.simplebanking.controller.TransactionStatus;
import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.InsufficientBalanceException;

/**
 * @author cagri
 */
public interface AccountServiceImpl {
    Account findAccount(String accountNumber);
    TransactionStatus credit(String accountNumber, double amount) throws InsufficientBalanceException;

    TransactionStatus debit(String accountNumber, double amount) throws InsufficientBalanceException;
}
