package com.eteration.simplebanking.model;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;


// This class is a place holder you can change the complete implementation
public class DepositTransaction extends Transaction{

    public DepositTransaction(Account account, Object amount){
        super(account, TransactionType.DEPOSIT_TRANSACTION, (Double) amount);
        construct();
    }

    public DepositTransaction(Object amount){
        super(TransactionType.DEPOSIT_TRANSACTION, (Double) amount);
        construct();
    }
    public DepositTransaction(){
        super(TransactionType.DEPOSIT_TRANSACTION);
        construct();
    }


    @Override
    void construct() {

    }








    /*

    public DepositTransaction(Object amount){
        super((Double) amount);
    }

    public DepositTransaction(Object amount, Account account) {
        super((Double) amount, account);
    }

    public DepositTransaction() {

    }

    @Override
    public void process(Account account) throws InsufficientBalanceException {

    }
    /*
    public DepositTransaction(Date date, double amount, Account account, String approvalCode) {
        super(date, amount, account, approvalCode);
    }

     */
}
