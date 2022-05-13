package com.greedy.dduckleaf.settlement.calculate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "RefundingStatusForSettlement")
@Table(name = "TBL_REFUNDING_STATUS")
public class RefundingStatus {

    @Id
    @Column(name = "REFUNDING_STATUS_NO")
    private int refundingStatusNo;              //환불상태번호

    @Column(name = "REFUNDING_STATUS_NAME")
    private String refundingStatusName;         //환불상태명

    public RefundingStatus() {}

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
