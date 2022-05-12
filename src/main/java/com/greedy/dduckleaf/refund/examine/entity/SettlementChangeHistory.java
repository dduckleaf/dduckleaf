package com.greedy.dduckleaf.refund.examine.entity;

import javax.persistence.*;

@Entity(name = "SettlementChangeHistory")
@Table(name = "TBL_SETTLEMENT_CHANGE_HISTORY")
public class SettlementChangeHistory {
    @Id
    @Column(name = "SETTLEMENT_CHANGE_HISTORY_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int settlementChangeHistoryNo;

    @Column(name = "CHANGED_AMOUNT")
    private int changedAmount;

    @Column(name = "CHANGED_REASON")
    private String changedReason;

    @Column(name = "CHANGED_DATE")
    private String changedDate;

    @Column(name ="SETTLEMENT_INFO_NO")
    private int settlementInfoNo;

    @Column(name = "SETTLEMENT_CHANGED_CATEGORY")
    private int settlementChangedCategory;

    @Column(name = "REFUNDING_HISTORY_NO")
    private int refundingHistoryNo;

    public SettlementChangeHistory() {
    }

    public SettlementChangeHistory(int settlementChangeHistoryNo, int changedAmount, String changedReason, String changedDate, int settlementInfoNo, int settlementChangedCategory, int refundingHistoryNo) {
        this.settlementChangeHistoryNo = settlementChangeHistoryNo;
        this.changedAmount = changedAmount;
        this.changedReason = changedReason;
        this.changedDate = changedDate;
        this.settlementInfoNo = settlementInfoNo;
        this.settlementChangedCategory = settlementChangedCategory;
        this.refundingHistoryNo = refundingHistoryNo;
    }

    public int getSettlementChangeHistoryNo() {
        return settlementChangeHistoryNo;
    }

    public void setSettlementChangeHistoryNo(int settlementChangeHistoryNo) {
        this.settlementChangeHistoryNo = settlementChangeHistoryNo;
    }

    public int getChangedAmount() {
        return changedAmount;
    }

    public void setChangedAmount(int changedAmount) {
        this.changedAmount = changedAmount;
    }

    public String getChangedReason() {
        return changedReason;
    }

    public void setChangedReason(String changedReason) {
        this.changedReason = changedReason;
    }

    public String getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(String changedDate) {
        this.changedDate = changedDate;
    }

    public int getSettlementInfoNo() {
        return settlementInfoNo;
    }

    public void setSettlementInfoNo(int settlementInfoNo) {
        this.settlementInfoNo = settlementInfoNo;
    }

    public int getSettlementChangedCategory() {
        return settlementChangedCategory;
    }

    public void setSettlementChangedCategory(int settlementChangedCategory) {
        this.settlementChangedCategory = settlementChangedCategory;
    }

    public int getRefundingHistoryNo() {
        return refundingHistoryNo;
    }

    public void setRefundingHistoryNo(int refundingHistoryNo) {
        this.refundingHistoryNo = refundingHistoryNo;
    }

    @Override
    public String toString() {
        return "SettlementChangeHistory{" +
                "settlementChangeHistoryNo=" + settlementChangeHistoryNo +
                ", changedAmount=" + changedAmount +
                ", changedReason='" + changedReason + '\'' +
                ", changedDate='" + changedDate + '\'' +
                ", settlementInfoNo=" + settlementInfoNo +
                ", settlementChangedCategory=" + settlementChangedCategory +
                ", refundingHistoryNo=" + refundingHistoryNo +
                '}';
    }
}
