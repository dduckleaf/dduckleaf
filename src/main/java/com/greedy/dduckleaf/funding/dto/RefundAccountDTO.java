package com.greedy.dduckleaf.funding.dto;

public class RefundAccountDTO {

    private int bankCode;
    private String accountNo;

    public RefundAccountDTO() {
    }

    public RefundAccountDTO(int bankCode, String accountNo) {
        this.bankCode = bankCode;
        this.accountNo = accountNo;
    }

    public int getBankCode() {
        return bankCode;
    }

    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
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
