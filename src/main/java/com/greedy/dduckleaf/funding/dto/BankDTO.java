package com.greedy.dduckleaf.funding.dto;

public class BankDTO {
    private int bankNo;
    private String bankName;

    public BankDTO() {
    }

    public BankDTO(int bankNo, String bankName) {
        this.bankNo = bankNo;
        this.bankName = bankName;
    }

    public int getBankNo() {
        return bankNo;
    }

    public void setBankNo(int bankNo) {
        this.bankNo = bankNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "BankDTO{" +
                "bankNo=" + bankNo +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}
