package com.greedy.dduckleaf.refund.regist.dto;

public class RefundingDTO {

    private int refundingInfoNo;
    private String refundingDate;
    private int refundingCategoryNo;
    private String refundingReason;
    private int refundingStatusNo;
    private int projectNo;
    private String refundingAccount;
    private int bankNo;
    private String refundingMemberName;
    private int memberNo;
    private int fundingInfoNo;

    public RefundingDTO() {
    }

    public RefundingDTO(int refundingInfoNo, String refundingDate, int refundingCategoryNo, String refundingReason, int refundingStatusNo, int projectNo, String refundingAccount, int bankNo, String refundingMemberName, int memberNo, int fundingInfoNo) {
        this.refundingInfoNo = refundingInfoNo;
        this.refundingDate = refundingDate;
        this.refundingCategoryNo = refundingCategoryNo;
        this.refundingReason = refundingReason;
        this.refundingStatusNo = refundingStatusNo;
        this.projectNo = projectNo;
        this.refundingAccount = refundingAccount;
        this.bankNo = bankNo;
        this.refundingMemberName = refundingMemberName;
        this.memberNo = memberNo;
        this.fundingInfoNo = fundingInfoNo;
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

    public int getRefundingCategoryNo() {
        return refundingCategoryNo;
    }

    public void setRefundingCategoryNo(int refundingCategoryNo) {
        this.refundingCategoryNo = refundingCategoryNo;
    }

    public String getRefundingReason() {
        return refundingReason;
    }

    public void setRefundingReason(String refundingReason) {
        this.refundingReason = refundingReason;
    }

    public int getRefundingStatusNo() {
        return refundingStatusNo;
    }

    public void setRefundingStatusNo(int refundingStatusNo) {
        this.refundingStatusNo = refundingStatusNo;
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

    public int getFundingInfoNo() {
        return fundingInfoNo;
    }

    public void setFundingInfoNo(int fundingInfoNo) {
        this.fundingInfoNo = fundingInfoNo;
    }

    @Override
    public String toString() {
        return "RefundingDTO{" +
                "refundingInfoNo=" + refundingInfoNo +
                ", refundingDate='" + refundingDate + '\'' +
                ", refundingCategoryNo=" + refundingCategoryNo +
                ", refundingReason='" + refundingReason + '\'' +
                ", refundingStatusNo=" + refundingStatusNo +
                ", projectNo=" + projectNo +
                ", refundingAccount='" + refundingAccount + '\'' +
                ", bankNo=" + bankNo +
                ", refundingMemberName='" + refundingMemberName + '\'' +
                ", memberNo=" + memberNo +
                ", fundingInfoNo=" + fundingInfoNo +
                '}';
    }
}