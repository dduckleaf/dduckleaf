package com.greedy.dduckleaf.refund.find.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity(name = "RefundingStatusForRefundingFind")
@Table(name = "TBL_REFUNDING_STATUS")
public class RefundingStatus {

    @Id
    @Column(name = "REFUNDING_STATUS_NO")
    private int refundingStatusNo;

    @Column(name = "REFUNDING_STATUS_NAME")
    private String refundingStatusName;

    public RefundingStatus() {
    }

    public RefundingStatus(int refundingStatusNo, String refundingStatusName) {
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
        return "RefundingStatus{" +
                "refundingStatusNo=" + refundingStatusNo +
                ", refundingStatusName='" + refundingStatusName + '\'' +
                '}';
    }
}