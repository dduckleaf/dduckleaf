package com.greedy.dduckleaf.refund.find.entity;

import javax.persistence.*;

@Entity(name = "RefundingCountForAdminFind")
@Table(name = "TBL_REFUNDING")
public class RefundingCount {

    @Id
    @Column(name = "REFUNDING_INFO_NO")
    private int refundingInfoNo;

    @Column(name = "REFUNDING_DATE")
    private String refundingDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "REFUNDING_CATEGORY_NO")
    private RefundingCategory refundingCategory;

    @Column(name = "REFUNDING_REASON")
    private String refundingReason;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "REFUNDING_STATUS_NO")
    private RefundingStatus refundingStatus;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "REFUNDING_ACCOUNT")
    private String refundingAccount;

    @Column(name = "BANK_NO")
    private int bankNo;

    @Column(name = "REFUNDING_MEMBER_NAME")
    private String refundingMemberName;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "REFUNDING_END_DATE")
    private String refundingEndDate;

    public RefundingCount() {
    }

    public RefundingCount(int refundingInfoNo, String refundingDate, RefundingCategory refundingCategory, String refundingReason, RefundingStatus refundingStatus, int projectNo, String refundingAccount, int bankNo, String refundingMemberName, int memberNo, String refundingEndDate) {
        this.refundingInfoNo = refundingInfoNo;
        this.refundingDate = refundingDate;
        this.refundingCategory = refundingCategory;
        this.refundingReason = refundingReason;
        this.refundingStatus = refundingStatus;
        this.projectNo = projectNo;
        this.refundingAccount = refundingAccount;
        this.bankNo = bankNo;
        this.refundingMemberName = refundingMemberName;
        this.memberNo = memberNo;
        this.refundingEndDate = refundingEndDate;
    }

    public int getRefundingInfoNo() {
        return refundingInfoNo;
    }

    public void setRefundingInfoNo(int refundingInfoNo) {
        this.refundingInfoNo = refundingInfoNo;
    }

    public String getRefundingDate() {
        return refundingDate;
    }

    public void setRefundingDate(String refundingDate) {
        this.refundingDate = refundingDate;
    }

    public RefundingCategory getRefundingCategory() {
        return refundingCategory;
    }

    public void setRefundingCategory(RefundingCategory refundingCategory) {
        this.refundingCategory = refundingCategory;
    }

    public String getRefundingReason() {
        return refundingReason;
    }

    public void setRefundingReason(String refundingReason) {
        this.refundingReason = refundingReason;
    }

    public RefundingStatus getRefundingStatus() {
        return refundingStatus;
    }

    public void setRefundingStatus(RefundingStatus refundingStatus) {
        this.refundingStatus = refundingStatus;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getRefundingAccount() {
        return refundingAccount;
    }

    public void setRefundingAccount(String refundingAccount) {
        this.refundingAccount = refundingAccount;
    }

    public int getBankNo() {
        return bankNo;
    }

    public void setBankNo(int bankNo) {
        this.bankNo = bankNo;
    }

    public String getRefundingMemberName() {
        return refundingMemberName;
    }

    public void setRefundingMemberName(String refundingMemberName) {
        this.refundingMemberName = refundingMemberName;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getRefundingEndDate() {
        return refundingEndDate;
    }

    public void setRefundingEndDate(String refundingEndDate) {
        this.refundingEndDate = refundingEndDate;
    }

    @Override
    public String toString() {
        return "RefundingCount{" +
                "refundingInfoNo=" + refundingInfoNo +
                ", refundingDate='" + refundingDate + '\'' +
                ", refundingCategory=" + refundingCategory +
                ", refundingReason='" + refundingReason + '\'' +
                ", refundingStatus=" + refundingStatus +
                ", projectNo=" + projectNo +
                ", refundingAccount='" + refundingAccount + '\'' +
                ", bankNo=" + bankNo +
                ", refundingMemberName='" + refundingMemberName + '\'' +
                ", memberNo=" + memberNo +
                ", refundingEndDate='" + refundingEndDate + '\'' +
                '}';
    }
}
