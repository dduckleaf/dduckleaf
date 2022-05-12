package com.greedy.dduckleaf.refund.find.dto;

public class RefundingDTO {

    private int refundingInfoNo;
    private String refundingDate;
    private RefundingCategoryDTO refundingCategory;
    private String refundingReason;
    private RefundingStatusDTO refundingStatus;
    private ProjectDTO project;
    private String refundingAccount;
    private int bankNo;
    private String refundingMemberName;
    private int memberNo;
    private FundingDTO funding;
    private String refundingEndDate;

    public RefundingDTO() {
    }

    public RefundingDTO(int refundingInfoNo, String refundingDate, RefundingCategoryDTO refundingCategory, String refundingReason, RefundingStatusDTO refundingStatus, ProjectDTO project, String refundingAccount, int bankNo, String refundingMemberName, int memberNo, FundingDTO funding, String refundingEndDate) {
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

    public RefundingCategoryDTO getRefundingCategory() {
        return refundingCategory;
    }

    public void setRefundingCategory(RefundingCategoryDTO refundingCategory) {
        this.refundingCategory = refundingCategory;
    }

    public String getRefundingReason() {
        return refundingReason;
    }

    public void setRefundingReason(String refundingReason) {
        this.refundingReason = refundingReason;
    }

    public RefundingStatusDTO getRefundingStatus() {
        return refundingStatus;
    }

    public void setRefundingStatus(RefundingStatusDTO refundingStatus) {
        this.refundingStatus = refundingStatus;
    }

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
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

    public FundingDTO getFunding() {
        return funding;
    }

    public void setFunding(FundingDTO funding) {
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
        return "RefundingDTO{" +
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