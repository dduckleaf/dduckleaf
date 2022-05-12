package com.greedy.dduckleaf.settlement.dto;

import java.util.List;

public class SettlementInfoDTO {

    private int settlementInfoNo;                       //정산정보번호
    private int fundingTotalAmount;                     //펀딩금총액
    private int donateAmount;                           //후원금총액
    private int settlementTotalAmount;                  //정산금총액
    private int totalCommissionAmount;                  //수수료총액
    private ProjectDTO project;                         //프로젝트번호
    private List<SettlementPaymentInfoDTO> settlementPaymentInfoList;
    private List<SettlementChangeHistoryDTO> settlementChangeHistoryList;

    public SettlementInfoDTO() {}

    public SettlementInfoDTO(int settlementInfoNo, int fundingTotalAmount, int donateAmount, int settlementTotalAmount,
                             int totalCommissionAmount, ProjectDTO project, List<SettlementPaymentInfoDTO> settlementPaymentInfoList,
                             List<SettlementChangeHistoryDTO> settlementChangeHistoryList) {
        this.settlementInfoNo = settlementInfoNo;
        this.fundingTotalAmount = fundingTotalAmount;
        this.donateAmount = donateAmount;
        this.settlementTotalAmount = settlementTotalAmount;
        this.totalCommissionAmount = totalCommissionAmount;
        this.project = project;
        this.settlementPaymentInfoList = settlementPaymentInfoList;
        this.settlementChangeHistoryList = settlementChangeHistoryList;
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

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    public List<SettlementPaymentInfoDTO> getSettlementPaymentInfoList() {
        return settlementPaymentInfoList;
    }

    public void setSettlementPaymentInfoList(List<SettlementPaymentInfoDTO> settlementPaymentInfoList) {
        this.settlementPaymentInfoList = settlementPaymentInfoList;
    }

    public List<SettlementChangeHistoryDTO> getSettlementChangeHistoryList() {
        return settlementChangeHistoryList;
    }

    public void setSettlementChangeHistoryList(List<SettlementChangeHistoryDTO> settlementChangeHistoryList) {
        this.settlementChangeHistoryList = settlementChangeHistoryList;
    }

    @Override
    public String toString() {
        return "SettlementInfo{" +
                "settlementInfoNo=" + settlementInfoNo +
                ", fundingTotalAmount=" + fundingTotalAmount +
                ", donateAmount=" + donateAmount +
                ", settlementTotalAmount=" + settlementTotalAmount +
                ", totalCommissionAmount=" + totalCommissionAmount +
//                ", project=" + project +
                '}';
    }
}
