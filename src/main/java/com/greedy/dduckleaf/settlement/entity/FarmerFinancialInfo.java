package com.greedy.dduckleaf.settlement.entity;

import javax.persistence.*;

@Entity(name = "FarmerFinancialInfoForSettlement")
@Table(name = "TBL_FARMER_FINANCIAL_INFO")
public class FarmerFinancialInfo {

    @Id
    @Column(name = "FINANCIAL_INFO_NO")
    private int financialInfoNo;                                //파머금융정보번호

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FARMER_NO")
    private FarmerInfo farmer;                                  //파머번호

    @Column(name = "FARMER_ACCOUNT")
    private String farmerAccount;                               //계좌번호

    @Column(name = "FARMER_NAME")
    private String farmerName;                                  //예금주

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BANK_NO")
    private Bank bank;                                          //은행번호

    @Column(name = "SETTLEMENT_POLICY_CHECK_STATUS")
    private String settlementPolicyCheckStatus;                 //정산 정책 확인

    @Column(name = "SETTLEMENT_POLICY_CHECK_DATE")
    private String settlementPolicyCheckDate;                   //정산 정책 확인일

    public FarmerFinancialInfo() {}

    public FarmerFinancialInfo(int financialInfoNo, FarmerInfo farmer, String farmerAccount, String farmerName,
                               Bank bank, String settlementPolicyCheckStatus, String settlementPolicyCheckDate) {
        this.financialInfoNo = financialInfoNo;
        this.farmer = farmer;
        this.farmerAccount = farmerAccount;
        this.farmerName = farmerName;
        this.bank = bank;
        this.settlementPolicyCheckStatus = settlementPolicyCheckStatus;
        this.settlementPolicyCheckDate = settlementPolicyCheckDate;
    }

    public int getFinancialInfoNo() {
        return financialInfoNo;
    }

    public void setFinancialInfoNo(int financialInfoNo) {
        this.financialInfoNo = financialInfoNo;
    }

    public FarmerInfo getFarmer() {
        return farmer;
    }

    public void setFarmer(FarmerInfo farmer) {
        this.farmer = farmer;
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

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
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
                ", farmer=" + farmer +
                ", farmerAccount='" + farmerAccount + '\'' +
                ", farmerName='" + farmerName + '\'' +
                ", bank=" + bank +
                ", settlementPolicyCheckStatus='" + settlementPolicyCheckStatus + '\'' +
                ", settlementPolicyCheckDate='" + settlementPolicyCheckDate + '\'' +
                '}';
    }
}
