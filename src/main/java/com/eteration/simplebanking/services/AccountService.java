package com.eteration.simplebanking.services;


import com.eteration.simplebanking.controller.TransactionStatus;
import com.eteration.simplebanking.enums.TransactionStatusType;
import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.repository.AccountRepository;
import com.eteration.simplebanking.repository.TransactionRepository;
import com.eteration.simplebanking.services.impl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService implements AccountServiceImpl {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Account findAccount(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (Objects.nonNull(account)) {

            return account;
        }
        return null;
    }

    @Override
    public TransactionStatus credit(String accountNumber, DepositTransaction transaction) throws InsufficientBalanceException {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account != null) {
            transaction = new DepositTransaction(account, transaction.getAmount());
            account.post(transaction);
            accountRepository.save(account);
            return new TransactionStatus(TransactionStatusType.OK);
        }
        return new TransactionStatus(TransactionStatusType.ERROR);
    }


    @Override
    public TransactionStatus debit(String accountNumber, WithdrawalTransaction transaction) throws InsufficientBalanceException {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        TransactionStatus transactionStatus = null;
        if (account != null) {
            transaction = new WithdrawalTransaction(transaction.getAmount());
            account.post(transaction);
            accountRepository.save(account);
            return new TransactionStatus(TransactionStatusType.OK);
        }
        return new TransactionStatus(TransactionStatusType.ERROR);
    }
}
