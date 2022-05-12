package com.greedy.dduckleaf.refund.examine.entity;

import javax.persistence.*;

@Entity(name = "SettlementInfoForRefundingExamine")
@Table(name = "TBL_SETTLEMENT_INFO")
public class SettlementInfo {

    @Id
    @Column(name = "SETTLEMENT_INFO_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int settlementInfoNo;                       //정산정보번호

    @Column(name = "FUNDING_TOTAL_AMOUNT")
    private int fundingTotalAmount;                     //펀딩금총액

    @Column(name = "DONATE_AMOUNT")
    private int donateAmount;                           //후원금총액

    @Column(name = "SETTLEMENT_TOTAL_AMOUNT")
    private int settlementTotalAmount;                  //정산금총액

    @Column(name = "TOTAL_COMMISSION_AMOUNT")
    private int totalCommissionAmount;                  //수수료총액

    @Column(name = "PROJECT_NO")
    private int projectNo;                            //프로젝트 번호

    public SettlementInfo() {
    }

    public SettlementInfo(int settlementInfoNo, int fundingTotalAmount, int donateAmount, int settlementTotalAmount, int totalCommissionAmount, int projectNo) {
        this.settlementInfoNo = settlementInfoNo;
        this.fundingTotalAmount = fundingTotalAmount;
        this.donateAmount = donateAmount;
        this.settlementTotalAmount = settlementTotalAmount;
        this.totalCommissionAmount = totalCommissionAmount;
        this.projectNo = projectNo;
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

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    @Override
    public String toString() {
        return "SettlementInfo{" +
                "settlementInfoNo=" + settlementInfoNo +
                ", fundingTotalAmount=" + fundingTotalAmount +
                ", donateAmount=" + donateAmount +
                ", settlementTotalAmount=" + settlementTotalAmount +
                ", totalCommissionAmount=" + totalCommissionAmount +
                ", projectNo=" + projectNo +
                '}';
    }
}
