package com.eteration.simplebanking.model;


import javax.persistence.Entity;
import java.util.Date;


// This class is a place holder you can change the complete implementation
@Entity
public class DepositTransaction extends Transaction{

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
