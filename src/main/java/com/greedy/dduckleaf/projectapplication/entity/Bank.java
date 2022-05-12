package com.greedy.dduckleaf.projectapplication.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.List;


@Entity(name = "Bank")
@Table(name = "TBL_BANK")
@DynamicInsert
public class Bank {

    @Id
    @Column(name = "BANK_NO")
    private int bankNo;

    @Column(name = "BANK_NAME")
    private String bankName;

    @OneToMany(mappedBy = "bank")
    private List<FarmerFinancialInfo> financialInfoList;

    public Bank() {
    }

    public Bank(int bankNo, String bankName, List<FarmerFinancialInfo> financialInfoList) {
        this.bankNo = bankNo;
        this.bankName = bankName;
        this.financialInfoList = financialInfoList;
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

    public List<FarmerFinancialInfo> getFinancialInfoList() {
        return financialInfoList;
    }

    public void setFinancialInfoList(List<FarmerFinancialInfo> financialInfoList) {
        this.financialInfoList = financialInfoList;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankNo=" + bankNo +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}
