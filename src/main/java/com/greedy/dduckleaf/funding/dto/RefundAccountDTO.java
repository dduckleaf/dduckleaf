package com.greedy.dduckleaf.funding.dto;

public class RefundAccountDTO {

    private int bankCode;
    private int accountNo;

    public RefundAccountDTO() {
    }

    public RefundAccountDTO(int bankCode, int accountNo) {
        this.bankCode = bankCode;
        this.accountNo = accountNo;
    }

    public int getBankCode() {
        return bankCode;
    }

    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    @Override
    public String toString() {
        return "RefundAccountDTO{" +
                "bankCode=" + bankCode +
                ", accountNo='" + accountNo + '\'' +
                '}';
    }
}
