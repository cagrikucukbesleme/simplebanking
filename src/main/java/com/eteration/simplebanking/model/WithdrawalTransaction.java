package com.eteration.simplebanking.model;


import javax.persistence.Entity;
import java.util.Date;

// This class is a place holder you can change the complete implementation
@Entity
public class WithdrawalTransaction extends Transaction{
    public WithdrawalTransaction(Object amount) {
        super((Double) amount);
    }
    public WithdrawalTransaction( Object amount, Account account) {
        super( (Double) amount, account);
    }
    public WithdrawalTransaction(){

    }

    @Override
    public void process(Account account) throws InsufficientBalanceException {

    }
}


