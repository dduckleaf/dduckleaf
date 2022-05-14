package com.greedy.dduckleaf.funding.dto;

public class FundingDTO {
    private int fundingInfoNo;
    private String fundingDate;
    private int fundingAmount;
    private int rewardAmount;
    private String fundingStatus;
    private int donateAmount;
    private int projectNo;
    private int shippingFeeNo;
    private int memberNo;
    private String rewardCategoryName;
    private String extraShippingFeeStatus;
    private BankDTO refundBankCode;
    private String refundAccount;
    private String refundName;
    private ProjectDTO project;

    private RefundAccountDTO refundAccountInfo;

    public FundingDTO() {
    }

    public FundingDTO(int fundingInfoNo, String fundingDate, int fundingAmount, int rewardAmount, String fundingStatus, int donateAmount, int projectNo, int shippingFeeNo, int memberNo, String rewardCategoryName, String extraShippingFeeStatus, BankDTO refundBankCode, String refundAccount, String refundName, ProjectDTO project, RefundAccountDTO refundAccountInfo) {
        this.fundingInfoNo = fundingInfoNo;
        this.fundingDate = fundingDate;
        this.fundingAmount = fundingAmount;
        this.rewardAmount = rewardAmount;
        this.fundingStatus = fundingStatus;
        this.donateAmount = donateAmount;
        this.projectNo = projectNo;
        this.shippingFeeNo = shippingFeeNo;
        this.memberNo = memberNo;
        this.rewardCategoryName = rewardCategoryName;
        this.extraShippingFeeStatus = extraShippingFeeStatus;
        this.refundBankCode = refundBankCode;
        this.refundAccount = refundAccount;
        this.refundName = refundName;
        this.project = project;
        this.refundAccountInfo = refundAccountInfo;
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

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public int getShippingFeeNo() {
        return shippingFeeNo;
    }

    public void setShippingFeeNo(int shippingFeeNo) {
        this.shippingFeeNo = shippingFeeNo;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getRewardCategoryName() {
        return rewardCategoryName;
    }

    public void setRewardCategoryName(String rewardCategoryName) {
        this.rewardCategoryName = rewardCategoryName;
    }

    public String getExtraShippingFeeStatus() {
        return extraShippingFeeStatus;
    }

    public void setExtraShippingFeeStatus(String extraShippingFeeStatus) {
        this.extraShippingFeeStatus = extraShippingFeeStatus;
    }

    public BankDTO getRefundBankCode() {
        return refundBankCode;
    }

    public void setRefundBankCode(BankDTO refundBankCode) {
        this.refundBankCode = refundBankCode;
    }

    public String getRefundAccount() {
        return refundAccount;
    }

    public void setRefundAccount(String refundAccount) {
        this.refundAccount = refundAccount;
    }

    public String getRefundName() {
        return refundName;
    }

    public void setRefundName(String refundName) {
        this.refundName = refundName;
    }

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    public RefundAccountDTO getRefundAccountInfo() {
        return refundAccountInfo;
    }

    public void setRefundAccountInfo(RefundAccountDTO refundAccountInfo) {
        this.refundAccountInfo = refundAccountInfo;
    }
}
