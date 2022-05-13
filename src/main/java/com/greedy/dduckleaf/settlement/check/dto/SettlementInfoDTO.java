package com.greedy.dduckleaf.settlement.check.dto;

public class SettlementInfoDTO {

    private int settlementInfoNo;                       //정산정보번호
    private int fundingTotalAmount;                     //펀딩금총액
    private int donateAmount;                           //후원금총액
    private int settlementTotalAmount;                  //정산금총액
    private int totalCommissionAmount;                  //수수료총액
    private String calculateDate;                       //정산금 계산일
    private ProjectDTO project;                  //프로젝트 번호

    public SettlementInfoDTO() {}

    public SettlementInfoDTO(int settlementInfoNo, int fundingTotalAmount, int donateAmount, int settlementTotalAmount,
                             int totalCommissionAmount, String calculateDate, ProjectDTO project) {
        this.settlementInfoNo = settlementInfoNo;
        this.fundingTotalAmount = fundingTotalAmount;
        this.donateAmount = donateAmount;
        this.settlementTotalAmount = settlementTotalAmount;
        this.totalCommissionAmount = totalCommissionAmount;
        this.calculateDate = calculateDate;
        this.project = project;
    }

    public int getSettlementInfoNo() {
        return settlementInfoNo;
    }

    public void setSettlementInfoNo(int settlementInfoNo) {
        this.settlementInfoNo = settlementInfoNo;
    }

    public int getFundingTotalAmount() {
        return fundingTotalAmount;
    }

    public void setFundingTotalAmount(int fundingTotalAmount) {
        this.fundingTotalAmount = fundingTotalAmount;
    }

    public int getDonateAmount() {
        return donateAmount;
    }

    public void setDonateAmount(int donateAmount) {
        this.donateAmount = donateAmount;
    }

    public int getSettlementTotalAmount() {
        return settlementTotalAmount;
    }

    public void setSettlementTotalAmount(int settlementTotalAmount) {
        this.settlementTotalAmount = settlementTotalAmount;
    }

    public int getTotalCommissionAmount() {
        return totalCommissionAmount;
    }

    public void setTotalCommissionAmount(int totalCommissionAmount) {
        this.totalCommissionAmount = totalCommissionAmount;
    }

    public String getCalculateDate() {
        return calculateDate;
    }

    public void setCalculateDate(String calculateDate) {
        this.calculateDate = calculateDate;
    }

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "SettlementInfoDTO{" +
                "settlementInfoNo=" + settlementInfoNo +
                ", fundingTotalAmount=" + fundingTotalAmount +
                ", donateAmount=" + donateAmount +
                ", settlementTotalAmount=" + settlementTotalAmount +
                ", totalCommissionAmount=" + totalCommissionAmount +
                ", calculateDate='" + calculateDate + '\'' +
                ", project=" + project +
                '}';
    }
}