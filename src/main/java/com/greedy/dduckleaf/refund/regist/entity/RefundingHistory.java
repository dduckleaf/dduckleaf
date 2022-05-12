package com.greedy.dduckleaf.refund.regist.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "RefundingHistoryForRefundingRegist")
@Table(name = "TBL_REFUNDING_HISTORY")
public class RefundingHistory {

    @Id
    @Column(name = "REFUNDING_HISTORY_NO")
    private int refundingHisotryNo;

    @Column(name = "MANAGER_TYPE")
    private String magagerType;

    @Column(name = "REFUNDING_HISTORY_DATE")
    private String refundingHistoryDate;

    @Column(name = "REFUNDING_STATUS_NO")
    private int refundingStatus;

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
    private int refundObjectionNo;

    @Column(name = "REFUNDING_MEMBER_NO")
    private int refundingMemberNo;

    public RefundingHistory() {
    }

    public RefundingHistory(int refundingHisotryNo, String magagerType, String refundingHistoryDate, int refundingStatus, String historyCategory, int refundingAmount, String refundingRefuseReason, String refundingHistoryCategory, int refundingInfoNo, int refundObjectionNo, int refundingMemberNo) {
        this.refundingHisotryNo = refundingHisotryNo;
        this.magagerType = magagerType;
        this.refundingHistoryDate = refundingHistoryDate;
        this.refundingStatus = refundingStatus;
        this.historyCategory = historyCategory;
        this.refundingAmount = refundingAmount;
        this.refundingRefuseReason = refundingRefuseReason;
        this.refundingHistoryCategory = refundingHistoryCategory;
        this.refundingInfoNo = refundingInfoNo;
        this.refundObjectionNo = refundObjectionNo;
        this.refundingMemberNo = refundingMemberNo;
    }

    public int getRefundingHisotryNo() {
        return refundingHisotryNo;
    }

    public void setRefundingHisotryNo(int refundingHisotryNo) {
        this.refundingHisotryNo = refundingHisotryNo;
    }

    public String getMagagerType() {
        return magagerType;
    }

    public void setMagagerType(String magagerType) {
        this.magagerType = magagerType;
    }

    public String getRefundingHistoryDate() {
        return refundingHistoryDate;
    }

    public void setRefundingHistoryDate(String refundingHistoryDate) {
        this.refundingHistoryDate = refundingHistoryDate;
    }

    public int getRefundingStatus() {
        return refundingStatus;
    }

    public void setRefundingStatus(int refundingStatus) {
        this.refundingStatus = refundingStatus;
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

    public int getRefundObjectionNo() {
        return refundObjectionNo;
    }

    public void setRefundObjectionNo(int refundObjectionNo) {
        this.refundObjectionNo = refundObjectionNo;
    }

    public int getRefundingMemberNo() {
        return refundingMemberNo;
    }

    public void setRefundingMemberNo(int refundingMemberNo) {
        this.refundingMemberNo = refundingMemberNo;
    }

    @Override
    public String toString() {
        return "RefundingHistory{" +
                "refundingHisotryNo=" + refundingHisotryNo +
                ", magagerType='" + magagerType + '\'' +
                ", refundingHistoryDate='" + refundingHistoryDate + '\'' +
                ", refundingStatus=" + refundingStatus +
                ", historyCategory='" + historyCategory + '\'' +
                ", refundingAmount=" + refundingAmount +
                ", refundingRefuseReason='" + refundingRefuseReason + '\'' +
                ", refundingHistoryCategory='" + refundingHistoryCategory + '\'' +
                ", refundingInfoNo=" + refundingInfoNo +
                ", refundObjectionNo=" + refundObjectionNo +
                ", refundingMemberNo=" + refundingMemberNo +
                '}';
    }
}