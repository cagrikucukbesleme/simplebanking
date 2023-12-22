package com.eteration.simplebanking.controller;


// This class is a place holder you can change the complete implementation

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
public class TransactionStatus {

    private String status;
    private String approvalCode;

    public TransactionStatus(String status, String approvalCode) {
        this.status = status;
        this.approvalCode = approvalCode;
    }

    public TransactionStatus(String status) {
        this.status = status;
    }

}
