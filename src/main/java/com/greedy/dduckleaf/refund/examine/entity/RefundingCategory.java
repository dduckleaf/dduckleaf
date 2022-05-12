package com.greedy.dduckleaf.refund.examine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "RefundingCategoryForRefundingFarmerExamine")
@Table(name = "TBL_REFUNDING_CATEGORY")
public class RefundingCategory {

    @Id
    @Column(name = "REFUNDING_CATEGORY_NO")
    private int refundingCategoryNo;

    @Column(name = "REFUNDING_CATEGORY_NAME")
    private String refundingCategoryName;

    public RefundingCategory() {
    }

    public RefundingCategory(int refundingCategoryNo, String refundingCategoryName) {
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
        return "RefundingCategory{" +
                "refundingCategoryNo=" + refundingCategoryNo +
                ", refundingCategoryName='" + refundingCategoryName + '\'' +
                '}';
    }
}