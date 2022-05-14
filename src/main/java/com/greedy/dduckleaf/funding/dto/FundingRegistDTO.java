package com.greedy.dduckleaf.funding.dto;

public class FundingRegistDTO {
    private int memberNo;
    private int totalFunding;
    private int rewardTotal;
    private int rewardPrice;
    private int rewardAmount;
    private int donate;
    private int shippingFee;
    private int extraShippingFee;
    private int projectNo;
    private String refundName;
    private ShippingAddressDTO shippingAddress;
    private RefundAccountDTO refundAccountInfo;

    public FundingRegistDTO() {
    }

    public FundingRegistDTO(int memberNo, int totalFunding, int rewardTotal, int rewardPrice, int rewardAmount, int donate, int shippingFee, int extraShippingFee, int projectNo, String refundName, ShippingAddressDTO shippingAddress, RefundAccountDTO refundAccountInfo) {
        this.memberNo = memberNo;
        this.totalFunding = totalFunding;
        this.rewardTotal = rewardTotal;
        this.rewardPrice = rewardPrice;
        this.rewardAmount = rewardAmount;
        this.donate = donate;
        this.shippingFee = shippingFee;
        this.extraShippingFee = extraShippingFee;
        this.projectNo = projectNo;
        this.refundName = refundName;
        this.shippingAddress = shippingAddress;
        this.refundAccountInfo = refundAccountInfo;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public int getTotalFunding() {
        return totalFunding;
    }

    public void setTotalFunding(int totalFunding) {
        this.totalFunding = totalFunding;
    }

    public int getRewardTotal() {
        return rewardTotal;
    }

    public void setRewardTotal(int rewardTotal) {
        this.rewardTotal = rewardTotal;
    }

    public int getRewardPrice() {
        return rewardPrice;
    }

    public void setRewardPrice(int rewardPrice) {
        this.rewardPrice = rewardPrice;
    }

    public int getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(int rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    public int getDonate() {
        return donate;
    }

    public void setDonate(int donate) {
        this.donate = donate;
    }

    public int getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(int shippingFee) {
        this.shippingFee = shippingFee;
    }

    public int getExtraShippingFee() {
        return extraShippingFee;
    }

    public void setExtraShippingFee(int extraShippingFee) {
        this.extraShippingFee = extraShippingFee;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getRefundName() {
        return refundName;
    }

    public void setRefundName(String refundName) {
        this.refundName = refundName;
    }

    public ShippingAddressDTO getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddressDTO shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public RefundAccountDTO getRefundAccountInfo() {
        return refundAccountInfo;
    }

    public void setRefundAccountInfo(RefundAccountDTO refundAccountInfo) {
        this.refundAccountInfo = refundAccountInfo;
    }
}