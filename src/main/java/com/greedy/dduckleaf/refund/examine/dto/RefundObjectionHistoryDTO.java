package com.greedy.dduckleaf.refund.examine.dto;

public class RefundObjectionHistoryDTO {

    private int refundObjectionHistoryNo;
    private int refundInfoNo;
    private String historyDate;
    private String historyCategory;
    private String refuseReason;
    private int refundObjectionNo;

    public RefundObjectionHistoryDTO() {
    }

    public RefundObjectionHistoryDTO(int refundObjectionHistoryNo, int refundInfoNo, String historyDate, String historyCategory, String refuseReason, int refundObjectionNo) {
        this.refundObjectionHistoryNo = refundObjectionHistoryNo;
        this.refundInfoNo = refundInfoNo;
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

    public int getRefundInfoNo() {
        return refundInfoNo;
    }

    public void setRefundInfoNo(int refundInfoNo) {
        this.refundInfoNo = refundInfoNo;
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
        return "RefundObjectionHistoryDTO{" +
                "refundObjectionHistoryNo=" + refundObjectionHistoryNo +
                ", refundInfoNo=" + refundInfoNo +
                ", historyDate='" + historyDate + '\'' +
                ", historyCategory='" + historyCategory + '\'' +
                ", refuseReason='" + refuseReason + '\'' +
                ", refundObjectionNo=" + refundObjectionNo +
                '}';
    }
}
