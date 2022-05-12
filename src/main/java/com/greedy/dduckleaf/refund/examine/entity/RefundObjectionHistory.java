package com.greedy.dduckleaf.refund.examine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "RefundObjectionHistory")
@Table(name = "TBL_REFUND_OBJECTION_HISTORY")
public class RefundObjectionHistory {

    @Id
    @Column(name = "REFUND_OBJECTION_HISTORY_NO")
    private int refundObjectionHistoryNo;

    @Column(name = "HISTORY_DATE")
    private String historyDate;

    @Column(name = "HISTORY_CATEGORY")
    private String historyCategory;

    @Column(name = "REFUSE_REASON")
    private String refuseReason;

    @Column(name = "REFUND_OBJECTION_NO")
    private int refundObjectionNo;

    public RefundObjectionHistory() {
    }

    public RefundObjectionHistory(int refundObjectionHistoryNo, String historyDate, String historyCategory, String refuseReason, int refundObjectionNo) {
        this.refundObjectionHistoryNo = refundObjectionHistoryNo;
        this.historyDate = historyDate;
        this.historyCategory = historyCategory;
        this.refuseReason = refuseReason;
        this.refundObjectionNo = refundObjectionNo;
    }

    public int getRefundObjectionHistoryNo() {
        return refundObjectionHistoryNo;
    }

    public void setRefundObjectionHistoryNo(int refundObjectionHistoryNo) {
        this.refundObjectionHistoryNo = refundObjectionHistoryNo;
    }

    public String getHistoryDate() {
        return historyDate;
    }

    public void setHistoryDate(String historyDate) {
        this.historyDate = historyDate;
    }

    public String getHistoryCategory() {
        return historyCategory;
    }

    public void setHistoryCategory(String historyCategory) {
        this.historyCategory = historyCategory;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public int getRefundObjectionNo() {
        return refundObjectionNo;
    }

    public void setRefundObjectionNo(int refundObjectionNo) {
        this.refundObjectionNo = refundObjectionNo;
    }

    @Override
    public String toString() {
        return "RefundObjectionHistory{" +
                "refundObjectionHistoryNo=" + refundObjectionHistoryNo +
                ", historyDate='" + historyDate + '\'' +
                ", historyCategory='" + historyCategory + '\'' +
                ", refuseReason='" + refuseReason + '\'' +
                ", refundObjectionNo=" + refundObjectionNo +
                '}';
    }
}