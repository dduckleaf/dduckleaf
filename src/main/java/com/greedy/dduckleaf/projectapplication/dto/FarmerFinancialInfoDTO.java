package com.greedy.dduckleaf.projectapplication.dto;

public class FarmerFinancialInfoDTO {       //파머 금융정보

    private int financialInfoNo;
    private int farmerNo;                   //파머번호
    private BankDTO bank;                   //은행번호
    private String taxReceiveEmail;         //세금계산서 발행 이메일
    private String farmerAccount;           //계좌번호
    private String farmerName;              //예금주
    private String settlementPolicyCheckStatus;
    private String settlementPolicyCheckDate;

    public FarmerFinancialInfoDTO() {}

    public FarmerFinancialInfoDTO(int financialInfoNo, int farmerNo, BankDTO bank, String taxReceiveEmail, String farmerAccount, String farmerName, String settlementPolicyCheckStatus, String settlementPolicyCheckDate) {
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

    public BankDTO getBank() {
        return bank;
    }

    public void setBank(BankDTO bank) {
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
        return "FarmerFinancialInfoDTO{" +
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
}
