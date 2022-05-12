package com.greedy.dduckleaf.refund.examine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "RefundingHistoryForFarmerExamine")
@Table(name = "TBL_REFUNDING_HISTORY")
public class RefundingHistory {

    @Id
    @Column(name = "REFUNDING_HISTORY_NO")
    private int refundingHisotryNo;

    @Column(name = "MANAGER_TYPE")
    private String managerType;

    @Column(name = "REFUNDING_HISTORY_DATE")
    private String refundingHistoryDate;

    @Column(name = "REFUNDING_STATUS_NO")
    private int refundingStatusNo;

    @Column(name = "HISTORY_CATEGORY")
    private String historyCategory;

    @Column(name = "REFUNDING_AMOUNT")
    private int refundingAmount;

    @Column(name = "REFUNDING_REFUSE_REASON")
    private String refundingRefuseReason;

    @Column(name = "REFUNDING_HISTORY_CATEGORY")
    private String refundingHistoryCategory;

    @Column(name = "REFUNDING_INFO_NO")
    private int refundingInfoNo;

    @Column(name = "REFUND_OBJECTION_NO")
    private int refundingObjectionNo;

    @Column(name = "REFUNDING_MEMBER_NO")
    private int refundingMemberNo;

    @Column(name = "MANAGER_NO")
    private int managerNo;

    public RefundingHistory() {
    }

    public RefundingHistory(int refundingHisotryNo, String managerType, String refundingHistoryDate, int refundingStatusNo, String historyCategory, int refundingAmount, String refundingRefuseReason, String refundingHistoryCategory, int refundingInfoNo, int refundingObjectionNo, int refundingMemberNo, int managerNo) {
        this.refundingHisotryNo = refundingHisotryNo;
        this.managerType = managerType;
        this.refundingHistoryDate = refundingHistoryDate;
        this.refundingStatusNo = refundingStatusNo;
        this.historyCategory = historyCategory;
        this.refundingAmount = refundingAmount;
        this.refundingRefuseReason = refundingRefuseReason;
        this.refundingHistoryCategory = refundingHistoryCategory;
        this.refundingInfoNo = refundingInfoNo;
        this.refundingObjectionNo = refundingObjectionNo;
        this.refundingMemberNo = refundingMemberNo;
        this.managerNo = managerNo;
    }

    public int getRefundingHisotryNo() {
        return refundingHisotryNo;
    }

    public void setRefundingHisotryNo(int refundingHisotryNo) {
        this.refundingHisotryNo = refundingHisotryNo;
    }

    public String getManagerType() {
        return managerType;
    }

    public void setManagerType(String managerType) {
        this.managerType = managerType;
    }

    public String getRefundingHistoryDate() {
        return refundingHistoryDate;
    }

    public void setRefundingHistoryDate(String refundingHistoryDate) {
        this.refundingHistoryDate = refundingHistoryDate;
    }

    public int getRefundingStatusNo() {
        return refundingStatusNo;
    }

    public void setRefundingStatusNo(int refundingStatusNo) {
        this.refundingStatusNo = refundingStatusNo;
    }

    public String getHistoryCategory() {
        return historyCategory;
    }

    public void setHistoryCategory(String historyCategory) {
        this.historyCategory = historyCategory;
    }

    public int getRefundingAmount() {
        return refundingAmount;
    }

    public void setRefundingAmount(int refundingAmount) {
        this.refundingAmount = refundingAmount;
    }

    public String getRefundingRefuseReason() {
        return refundingRefuseReason;
    }

    public void setRefundingRefuseReason(String refundingRefuseReason) {
        this.refundingRefuseReason = refundingRefuseReason;
    }

    public String getRefundingHistoryCategory() {
        return refundingHistoryCategory;
    }

    public void setRefundingHistoryCategory(String refundingHistoryCategory) {
        this.refundingHistoryCategory = refundingHistoryCategory;
    }

    public int getRefundingInfoNo() {
        return refundingInfoNo;
    }

    public void setRefundingInfoNo(int refundingInfoNo) {
        this.refundingInfoNo = refundingInfoNo;
    }

    public int getRefundingObjectionNo() {
        return refundingObjectionNo;
    }

    public void setRefundingObjectionNo(int refundingObjectionNo) {
        this.refundingObjectionNo = refundingObjectionNo;
    }

    public int getRefundingMemberNo() {
        return refundingMemberNo;
    }

    public void setRefundingMemberNo(int refundingMemberNo) {
        this.refundingMemberNo = refundingMemberNo;
    }

    public int getManagerNo() {
        return managerNo;
    }

    public void setManagerNo(int managerNo) {
        this.managerNo = managerNo;
    }

    @Override
    public String toString() {
        return "RefundingHistory{" +
                "refundingHisotryNo=" + refundingHisotryNo +
                ", managerType='" + managerType + '\'' +
                ", refundingHistoryDate='" + refundingHistoryDate + '\'' +
                ", refundingStatusNo=" + refundingStatusNo +
                ", historyCategory='" + historyCategory + '\'' +
                ", refundingAmount=" + refundingAmount +
                ", refundingRefuseReason='" + refundingRefuseReason + '\'' +
                ", refundingHistoryCategory='" + refundingHistoryCategory + '\'' +
                ", refundingInfoNo=" + refundingInfoNo +
                ", refundingObjectionNo=" + refundingObjectionNo +
                ", refundingMemberNo=" + refundingMemberNo +
                ", managerNo=" + managerNo +
                '}';
    }
}