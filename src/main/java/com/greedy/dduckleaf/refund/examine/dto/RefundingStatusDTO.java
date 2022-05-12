package com.greedy.dduckleaf.refund.examine.dto;

public class RefundingStatusDTO {

    private int refundingStatusNo;
    private String refundingStatusName;

    public RefundingStatusDTO() {
    }

    public RefundingStatusDTO(int refundingStatusNo, String refundingStatusName) {
        this.refundingStatusNo = refundingStatusNo;
        this.refundingStatusName = refundingStatusName;
    }

    public int getRefundingStatusNo() {
        return refundingStatusNo;
    }

    public void setRefundingStatusNo(int refundingStatusNo) {
        this.refundingStatusNo = refundingStatusNo;
    }

    public String getRefundingStatusName() {
        return refundingStatusName;
    }

    public void setRefundingStatusName(String refundingStatusName) {
        this.refundingStatusName = refundingStatusName;
    }

    @Override
    public String toString() {
        return "RefundingStatusDTO{" +
                "refundingStatusNo=" + refundingStatusNo +
                ", refundingStatusName='" + refundingStatusName + '\'' +
                '}';
    }
}
