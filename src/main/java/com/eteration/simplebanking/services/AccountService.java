package com.eteration.simplebanking.services;


import com.eteration.simplebanking.controller.TransactionStatus;
import com.eteration.simplebanking.model.*;
import com.eteration.simplebanking.repository.AccountRepository;
import com.eteration.simplebanking.repository.TransactionRepository;
import com.eteration.simplebanking.services.impl.AccountServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

// This class is a place holder you can change the complete implementation
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
        Account account=accountRepository.findByAccountNumber(accountNumber);
        if(Objects.nonNull(account)){
            return account;
        }
       return null;
    }

    @Override
    public TransactionStatus credit(String accountNumber, double amount) throws InsufficientBalanceException {
        Account account=accountRepository.findByAccountNumber(accountNumber);
        TransactionStatus transactionStatus;
        if (account != null) {
            Transaction transaction = new DepositTransaction(amount, account);
            account.post(transaction);
            transactionRepository.save(transaction);
            accountRepository.save(account);
            transactionStatus = new TransactionStatus("OK");
        } else {
            transactionStatus = new TransactionStatus("ERROR");
        }
        return transactionStatus;
    }


    @Override
    public TransactionStatus debit(String accountNumber, double amount) throws InsufficientBalanceException {
        Account account=accountRepository.findByAccountNumber(accountNumber);
        TransactionStatus transactionStatus;
        double balance= account.getBalance();
        if (account != null) {
            Transaction transaction = new WithdrawalTransaction(amount, account);
            account.post(transaction);
            transactionRepository.save(transaction);
            accountRepository.save(account);
            transactionStatus = new TransactionStatus("OK");
        } else {
            transactionStatus = new TransactionStatus("ERROR");
        }
        return transactionStatus;
    }
}
