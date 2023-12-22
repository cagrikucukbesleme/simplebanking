package com.eteration.simplebanking.services.impl;

import com.eteration.simplebanking.controller.TransactionStatus;
import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.WithdrawalTransaction;

/**
 * @author cagri
 */
public interface AccountServiceImpl {
    Account findAccount(String accountNumber);

    TransactionStatus credit(String accountNumber, DepositTransaction transaction) throws InsufficientBalanceException;

    TransactionStatus debit(String accountNumber, WithdrawalTransaction transaction) throws InsufficientBalanceException;
}
