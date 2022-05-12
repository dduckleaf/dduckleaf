package com.greedy.dduckleaf.projectapplication.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;


@Entity(name = "FarmerFinancialInfoForProjectApplication")
@Table(name = "TBL_FARMER_FINANCIAL_INFO")
@DynamicInsert
public class FarmerFinancialInfo {

    @Id
    @Column(name = "FINANCIAL_INFO_NO")
    private int financialInfoNo;

    @Column(name = "FARMER_NO")
    private int farmerNo;               //파머번호

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "BANK_NO")
    private Bank bank;                 //은행번호

    @Column(name = "TAX_RECEIVE_EMAIL")
    private String taxReceiveEmail;     //세금계산서 발행 이메일

    @Column(name = "FARMER_ACCOUNT")
    private String farmerAccount;       //계좌번호

    @Column(name = "FARMER_NAME")
    private String farmerName;          //예금주

    @Column(name = "SETTLEMENT_POLICY_CHECK_STATUS")
    private String settlementPolicyCheckStatus;

    @Column(name = "SETTLEMENT_POLICY_CHECK_DATE")
    private String settlementPolicyCheckDate;

    public FarmerFinancialInfo() {
    }

    public FarmerFinancialInfo(int financialInfoNo, int farmerNo, Bank bank, String taxReceiveEmail, String farmerAccount, String farmerName, String settlementPolicyCheckStatus, String settlementPolicyCheckDate) {
        this.financialInfoNo = financialInfoNo;
        this.farmerNo = farmerNo;
        this.bank = bank;
        this.taxReceiveEmail = taxReceiveEmail;
        this.farmerAccount = farmerAccount;
        this.farmerName = farmerName;
        this.settlementPolicyCheckStatus = settlementPolicyCheckStatus;
        this.settlementPolicyCheckDate = settlementPolicyCheckDate;
    }

    public int getFinancialInfoNo() {
        return financialInfoNo;
    }

    public void setFinancialInfoNo(int financialInfoNo) {
        this.financialInfoNo = financialInfoNo;
    }

    public int getFarmerNo() {
        return farmerNo;
    }

    public void setFarmerNo(int farmerNo) {
        this.farmerNo = farmerNo;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getTaxReceiveEmail() {
        return taxReceiveEmail;
    }

    public void setTaxReceiveEmail(String taxReceiveEmail) {
        this.taxReceiveEmail = taxReceiveEmail;
    }

    public String getFarmerAccount() {
        return farmerAccount;
    }

    public void setFarmerAccount(String farmerAccount) {
        this.farmerAccount = farmerAccount;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getSettlementPolicyCheckStatus() {
        return settlementPolicyCheckStatus;
    }

    public void setSettlementPolicyCheckStatus(String settlementPolicyCheckStatus) {
        this.settlementPolicyCheckStatus = settlementPolicyCheckStatus;
    }

    public String getSettlementPolicyCheckDate() {
        return settlementPolicyCheckDate;
    }

    public void setSettlementPolicyCheckDate(String settlementPolicyCheckDate) {
        this.settlementPolicyCheckDate = settlementPolicyCheckDate;
    }

    @Override
    public String toString() {
        return "FarmerFinancialInfo{" +
                "financialInfoNo=" + financialInfoNo +
                ", farmerNo=" + farmerNo +
                ", bank=" + bank +
                ", taxReceiveEmail='" + taxReceiveEmail + '\'' +
                ", farmerAccount='" + farmerAccount + '\'' +
                ", farmerName='" + farmerName + '\'' +
                ", settlementPolicyCheckStatus='" + settlementPolicyCheckStatus + '\'' +
                ", settlementPolicyCheckDate='" + settlementPolicyCheckDate + '\'' +
                '}';
    }

    @PrePersist
    public void prePersist() {

        this.farmerName = this.farmerName  == null ? "예금주" : this.farmerName ;
        this.taxReceiveEmail = this.taxReceiveEmail  == null ? "세금계산서 발행 이메일" : this.taxReceiveEmail ;
        this.farmerAccount = this.farmerAccount  == null ? "계좌번호" : this.farmerAccount ;
        this.settlementPolicyCheckDate = this.settlementPolicyCheckDate  == null ? java.sql.Date.valueOf(LocalDate.now()).toString() : this.settlementPolicyCheckDate ;

    }
}
