package com.greedy.dduckleaf.settlement.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "BankForSettlement")
@Table(name = " TBL_BANK")
public class Bank {

    @Id
    @Column(name = "BANK_NO")
    private int bankNo;                                     //은행번호

    @Column(name =  "BANK_NAME")
    private String bankName;                                //은행명

    @OneToMany(mappedBy = "bank")
    private List<FarmerFinancialInfo> farmerFinancialInfos;

    public Bank() {}

    public Bank(int bankNo, String bankName, List<FarmerFinancialInfo> farmerFinancialInfos) {
        this.bankNo = bankNo;
        this.bankName = bankName;
        this.farmerFinancialInfos = farmerFinancialInfos;
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

    public List<FarmerFinancialInfo> getFarmerFinancialInfos() {
        return farmerFinancialInfos;
    }

    public void setFarmerFinancialInfos(List<FarmerFinancialInfo> farmerFinancialInfos) {
        this.farmerFinancialInfos = farmerFinancialInfos;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankNo=" + bankNo +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}
