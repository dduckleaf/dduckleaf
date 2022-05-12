package com.greedy.dduckleaf.refund.examine.dto;

public class RefundingHistoryDTO {

    private int refundingHisotryNo;
    private String managerType;
    private String refundingHistoryDate;
    private int refundingStatusNo;
    private String hitoryCategory;
    private int refundingAmount;
    private String refundingRefuseReason;
    private String refundingHistoryCategory;
    private int refundingInfoNo;
    private int refundingObjectionNo;
    private int refundingMemberNo;

    public RefundingHistoryDTO() {
    }

    public RefundingHistoryDTO(int refundingHisotryNo, String managerType, String refundingHistoryDate, int refundingStatusNo, String hitoryCategory, int refundingAmount, String refundingRefuseReason, String refundingHistoryCategory, int refundingInfoNo, int refundingObjectionNo, int refundingMemberNo) {
        this.refundingHisotryNo = refundingHisotryNo;
        this.managerType = managerType;
        this.refundingHistoryDate = refundingHistoryDate;
        this.refundingStatusNo = refundingStatusNo;
        this.hitoryCategory = hitoryCategory;
        this.refundingAmount = refundingAmount;
        this.refundingRefuseReason = refundingRefuseReason;
        this.refundingHistoryCategory = refundingHistoryCategory;
        this.refundingInfoNo = refundingInfoNo;
        this.refundingObjectionNo = refundingObjectionNo;
        this.refundingMemberNo = refundingMemberNo;
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

    public String getHitoryCategory() {
        return hitoryCategory;
    }

    public void setHitoryCategory(String hitoryCategory) {
        this.hitoryCategory = hitoryCategory;
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

    @Override
    public String toString() {
        return "RefundingHistoryDTO{" +
                "refundingHisotryNo=" + refundingHisotryNo +
                ", managerType='" + managerType + '\'' +
                ", refundingHistoryDate='" + refundingHistoryDate + '\'' +
                ", refundingStatusNo=" + refundingStatusNo +
                ", hitoryCategory='" + hitoryCategory + '\'' +
                ", refundingAmount=" + refundingAmount +
                ", refundingRefuseReason='" + refundingRefuseReason + '\'' +
                ", refundingHistoryCategory='" + refundingHistoryCategory + '\'' +
                ", refundingInfoNo=" + refundingInfoNo +
                ", refundingObjectionNo=" + refundingObjectionNo +
                ", refundingMemberNo=" + refundingMemberNo +
                '}';
    }
}
