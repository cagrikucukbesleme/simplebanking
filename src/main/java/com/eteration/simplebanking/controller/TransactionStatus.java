package com.eteration.simplebanking.controller;


// This class is a place holder you can change the complete implementation

import com.eteration.simplebanking.enums.TransactionStatusType;

import java.io.Serializable;
import java.util.UUID;

public class TransactionStatus implements Serializable {

    private TransactionStatusType status;
    private String approvalCode;

    public TransactionStatus(TransactionStatusType status) {
        this.status = status;
        this.approvalCode = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "TransactionStatus{" +
                "status='" + status + '\'' +
                ", approvalCode='" + approvalCode + '\'' +
                '}';
    }

    public TransactionStatusType getStatus() {
        return status;
    }

    public void setStatus(TransactionStatusType status) {
        this.status = status;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }
}
