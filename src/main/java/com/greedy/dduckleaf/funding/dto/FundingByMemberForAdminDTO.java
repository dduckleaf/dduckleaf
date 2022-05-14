package com.greedy.dduckleaf.funding.dto;

public class FundingByMemberForAdminDTO {

    private int fundingNo;
    private String projectName;
    private int fundingAmount;
    private int donate;
    private String reward;
    private String rewardCount;
    private int shippingFee;
    private String date;

    public FundingByMemberForAdminDTO() {
    }

    public FundingByMemberForAdminDTO(int fundingNo, String projectName, int fundingAmount, int donate, String reward, String rewardCount, int shippingFee, String date) {
        this.fundingNo = fundingNo;
        this.projectName = projectName;
        this.fundingAmount = fundingAmount;
        this.donate = donate;
        this.reward = reward;
        this.rewardCount = rewardCount;
        this.shippingFee = shippingFee;
        this.date = date;
    }

    public int getFundingNo() {
        return fundingNo;
    }

    public void setFundingNo(int fundingNo) {
        this.fundingNo = fundingNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getFundingAmount() {
        return fundingAmount;
    }

    public void setFundingAmount(int fundingAmount) {
        this.fundingAmount = fundingAmount;
    }

    public int getDonate() {
        return donate;
    }

    public void setDonate(int donate) {
        this.donate = donate;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getRewardCount() {
        return rewardCount;
    }

    public void setRewardCount(String rewardCount) {
        this.rewardCount = rewardCount;
    }

    public int getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(int shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
