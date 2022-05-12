package com.greedy.dduckleaf.refund.examine.dto;

public class RefundingObjectionDTO {

    private int refundObjectionNo;
    private String refundObjectionReason;
    private int refundingInfoNo;
    private int refundObjectionMemberNo;

    public RefundingObjectionDTO() {
    }

    public RefundingObjectionDTO(int refundObjectionNo, String refundObjectionReason, int refundingInfoNo, int refundObjectionMemberNo) {
        this.refundObjectionNo = refundObjectionNo;
        this.refundObjectionReason = refundObjectionReason;
        this.refundingInfoNo = refundingInfoNo;
        this.refundObjectionMemberNo = refundObjectionMemberNo;
    }

    public int getRefundObjectionNo() {
        return refundObjectionNo;
    }

    public void setRefundObjectionNo(int refundObjectionNo) {
        this.refundObjectionNo = refundObjectionNo;
    }

    public String getRefundObjectionReason() {
        return refundObjectionReason;
    }

    public void setRefundObjectionReason(String refundObjectionReason) {
        this.refundObjectionReason = refundObjectionReason;
    }

    public int getRefundingInfoNo() {
        return refundingInfoNo;
    }

    public void setRefundingInfoNo(int refundingInfoNo) {
        this.refundingInfoNo = refundingInfoNo;
    }

    public int getRefundObjectionMemberNo() {
        return refundObjectionMemberNo;
    }

    public void setRefundObjectionMemberNo(int refundObjectionMemberNo) {
        this.refundObjectionMemberNo = refundObjectionMemberNo;
    }

    @Override
    public String toString() {
        return "RefundingObjectionDTO{" +
                "refundObjectionNo=" + refundObjectionNo +
                ", refundObjectionReason='" + refundObjectionReason + '\'' +
                ", refundingInfoNo=" + refundingInfoNo +
                ", refundObjectionMemberNo=" + refundObjectionMemberNo +
                '}';
    }
}
