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

    TransactionStatus credit(Account account, DepositTransaction transaction) throws InsufficientBalanceException;

    TransactionStatus debit(Account account, WithdrawalTransaction transaction) throws InsufficientBalanceException;
}
