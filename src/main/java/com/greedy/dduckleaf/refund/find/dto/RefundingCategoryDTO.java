package com.greedy.dduckleaf.refund.find.dto;

public class RefundingCategoryDTO {

    private int refundingCategoryNo;
    private String refundingCategoryName;

    public RefundingCategoryDTO() {
    }

    public RefundingCategoryDTO(int refundingCategoryNo, String refundingCategoryName) {
        this.refundingCategoryNo = refundingCategoryNo;
        this.refundingCategoryName = refundingCategoryName;
    }

    public int getRefundingCategoryNo() {
        return refundingCategoryNo;
    }

    public void setRefundingCategoryNo(int refundingCategoryNo) {
        this.refundingCategoryNo = refundingCategoryNo;
    }

    public String getRefundingCategoryName() {
        return refundingCategoryName;
    }

    public void setRefundingCategoryName(String refundingCategoryName) {
        this.refundingCategoryName = refundingCategoryName;
    }

    @Override
    public String toString() {
        return "RefundingCategoryDTO{" +
                "refundingCategoryNo=" + refundingCategoryNo +
                ", refundingCategoryName='" + refundingCategoryName + '\'' +
                '}';
    }
}