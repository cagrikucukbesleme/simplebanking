package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.services.impl.AccountServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account/v1")
@RequiredArgsConstructor
@Api("Api for account process")
public class AccountController {
    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping("/{accountNumber}")
    @ApiModelProperty("get account by account number")
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) {
        return new ResponseEntity<>(accountService.findAccount(accountNumber), HttpStatus.OK);

    }

    @PostMapping("/credit/{accountNumber}")
    @ApiModelProperty("post credit to account by account number")
    public ResponseEntity<TransactionStatus> credit(@PathVariable String accountNumber, @RequestBody DepositTransaction transaction) throws InsufficientBalanceException {
        Account account = accountService.findAccount(accountNumber);
        return ResponseEntity.ok(accountService.credit(account, transaction));
    }

    @PostMapping("/debit/{accountNumber}")
    @ApiModelProperty("post debit to account by account number")
    public ResponseEntity<TransactionStatus> debit(@PathVariable String accountNumber, @RequestBody WithdrawalTransaction transaction) throws InsufficientBalanceException {
        Account account = accountService.findAccount(accountNumber);
        return ResponseEntity.ok(accountService.debit(account, transaction));

    }
}