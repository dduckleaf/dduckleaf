package com.greedy.dduckleaf.refund.find.dto;

public class FundingDTO {

    private int fundingInfoNo;
    private String fundingDate;
    private int fundingAmount;
    private int rewardAmount;
    private String fundingStatus;
    private int donateAmount;
    private String refundName;
    private int projectNo;
    private int memberNo;
    private String extraShippingFeeStatus;
    private String refundAccount;

    public FundingDTO() {
    }

    public FundingDTO(int fundingInfoNo, String fundingDate, int fundingAmount, int rewardAmount, String fundingStatus, int donateAmount, String refundName, int projectNo, int memberNo, String extraShippingFeeStatus, String refundAccount) {
        this.fundingInfoNo = fundingInfoNo;
        this.fundingDate = fundingDate;
        this.fundingAmount = fundingAmount;
        this.rewardAmount = rewardAmount;
        this.fundingStatus = fundingStatus;
        this.donateAmount = donateAmount;
        this.refundName = refundName;
        this.projectNo = projectNo;
        this.memberNo = memberNo;
        this.extraShippingFeeStatus = extraShippingFeeStatus;
        this.refundAccount = refundAccount;
    }

    public int getFundingInfoNo() {
        return fundingInfoNo;
    }

    public void setFundingInfoNo(int fundingInfoNo) {
        this.fundingInfoNo = fundingInfoNo;
    }

    public String getFundingDate() {
        return fundingDate;
    }

    public void setFundingDate(String fundingDate) {
        this.fundingDate = fundingDate;
    }

    public int getFundingAmount() {
        return fundingAmount;
    }

    public void setFundingAmount(int fundingAmount) {
        this.fundingAmount = fundingAmount;
    }

    public int getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(int rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    public String getFundingStatus() {
        return fundingStatus;
    }

    public void setFundingStatus(String fundingStatus) {
        this.fundingStatus = fundingStatus;
    }

    public int getDonateAmount() {
        return donateAmount;
    }

    public void setDonateAmount(int donateAmount) {
        this.donateAmount = donateAmount;
    }

    public String getRefundName() {
        return refundName;
    }

    public void setRefundName(String refundName) {
        this.refundName = refundName;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getExtraShippingFeeStatus() {
        return extraShippingFeeStatus;
    }

    public void setExtraShippingFeeStatus(String extraShippingFeeStatus) {
        this.extraShippingFeeStatus = extraShippingFeeStatus;
    }

    public String getRefundAccount() {
        return refundAccount;
    }

    public void setRefundAccount(String refundAccount) {
        this.refundAccount = refundAccount;
    }

    @Override
    public String toString() {
        return "FundingDTO{" +
                "fundingInfoNo=" + fundingInfoNo +
                ", fundingDate='" + fundingDate + '\'' +
                ", fundingAmount=" + fundingAmount +
                ", rewardAmount=" + rewardAmount +
                ", fundingStatus='" + fundingStatus + '\'' +
                ", donateAmount=" + donateAmount +
                ", refundName='" + refundName + '\'' +
                ", projectNo=" + projectNo +
                ", memberNo=" + memberNo +
                ", extraShippingFeeStatus='" + extraShippingFeeStatus + '\'' +
                ", refundAccount=" + refundAccount +
                '}';
    }
}