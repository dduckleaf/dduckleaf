package com.greedy.dduckleaf.funding.entity;

import com.greedy.dduckleaf.refund.find.entity.Funding;
import com.greedy.dduckleaf.refund.find.entity.Project;
import com.greedy.dduckleaf.refund.find.entity.RefundingCategory;
import com.greedy.dduckleaf.refund.find.entity.RefundingStatus;

import javax.persistence.*;

@Entity(name = "RefundingForAdminFundingFindList")
@Table(name = "TBL_REFUNDING")
public class Refunding {

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PROJECT_NO")
    private Project project;

    @Column(name = "REFUNDING_ACCOUNT")
    private String refundingAccount;

    @Column(name = "BANK_NO")
    private int bankNo;

    @Column(name = "REFUNDING_MEMBER_NAME")
    private String refundingMemberName;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FUNDING_INFO_NO")
    private Funding funding;

    @Column(name = "REFUNDING_END_DATE")
    private String refundingEndDate;

    public Refunding() {
    }

    public Refunding(int refundingInfoNo, String refundingDate, RefundingCategory refundingCategory, String refundingReason, RefundingStatus refundingStatus, Project project, String refundingAccount, int bankNo, String refundingMemberName, int memberNo, Funding funding, String refundingEndDate) {
        this.refundingInfoNo = refundingInfoNo;
        this.refundingDate = refundingDate;
        this.refundingCategory = refundingCategory;
        this.refundingReason = refundingReason;
        this.refundingStatus = refundingStatus;
        this.project = project;
        this.refundingAccount = refundingAccount;
        this.bankNo = bankNo;
        this.refundingMemberName = refundingMemberName;
        this.memberNo = memberNo;
        this.funding = funding;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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

    public Funding getFunding() {
        return funding;
    }

    public void setFunding(Funding funding) {
        this.funding = funding;
    }

    public String getRefundingEndDate() {
        return refundingEndDate;
    }

    public void setRefundingEndDate(String refundingEndDate) {
        this.refundingEndDate = refundingEndDate;
    }

    @Override
    public String toString() {
        return "Refunding{" +
                "refundingInfoNo=" + refundingInfoNo +
                ", refundingDate='" + refundingDate + '\'' +
                ", refundingCategory=" + refundingCategory +
                ", refundingReason='" + refundingReason + '\'' +
                ", refundingStatus=" + refundingStatus +
                ", project=" + project +
                ", refundingAccount='" + refundingAccount + '\'' +
                ", bankNo=" + bankNo +
                ", refundingMemberName='" + refundingMemberName + '\'' +
                ", memberNo=" + memberNo +
                ", funding=" + funding +
                ", refundingEndDate='" + refundingEndDate + '\'' +
                '}';
    }
}