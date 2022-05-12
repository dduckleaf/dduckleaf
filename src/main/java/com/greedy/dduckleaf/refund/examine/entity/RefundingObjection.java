package com.greedy.dduckleaf.refund.examine.entity;

import javax.persistence.*;

@Entity(name = "RefundObjection")
@Table(name = "TBL_REFUND_OBJECTION")
public class RefundingObjection {

    @Id
    @Column(name = "REFUND_OBJECTION_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int refundObjectionNo;

    @Column(name = "REFUND_OBJECTRION_REASON")
    private String refundObjectionReason;

    @Column(name = "REFUNDING_INFO_NO")
    private int refundingInfoNo;

    @Column(name = "REFUND_OBJECTION_MEMBER_NO")
    private int refundObjectionMemberNo;

    @Column(name = "REFUND_STUATUS")
    private String refundStatus;

    public RefundingObjection() {
    }

    public RefundingObjection(int refundObjectionNo, String refundObjectionReason, int refundingInfoNo, int refundObjectionMemberNo, String refundStatus) {
        this.refundObjectionNo = refundObjectionNo;
        this.refundObjectionReason = refundObjectionReason;
        this.refundingInfoNo = refundingInfoNo;
        this.refundObjectionMemberNo = refundObjectionMemberNo;
        this.refundStatus = refundStatus;
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

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    @Override
    public String toString() {
        return "RefundingObjection{" +
                "refundObjectionNo=" + refundObjectionNo +
                ", refundObjectionReason='" + refundObjectionReason + '\'' +
                ", refundingInfoNo=" + refundingInfoNo +
                ", refundObjectionMemberNo=" + refundObjectionMemberNo +
                ", refundStatus='" + refundStatus + '\'' +
                '}';
    }
}