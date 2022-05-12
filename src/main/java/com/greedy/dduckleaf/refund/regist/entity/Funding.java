package com.greedy.dduckleaf.refund.regist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "FundingForRefundingRegist")
@Table(name = "TBL_FUNDING_INFO")
public class Funding {

    @Id
    @Column(name = "FUNDING_INFO_NO")
    private int fundingInfoNo;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "SHIPPING_FEE_NO")
    private int shippingFeeNo;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "FUNDING_DATE")
    private String fundingDate;

    @Column(name = "FUNDING_AMOUNT")
    private int fundingAmount;

    @Column(name = "DONATE_AMOUNT")
    private int donateAmount;

    @Column(name = "REWARD_AMOUNT")
    private int rewardAmount;

    @Column(name = "FUNDING_STATUS")
    private String fundingStatus;

    @Column(name = "REFUND_BANK_CODE")
    private int refundBankCode;

    @Column(name = "REFUND_ACCOUNT")
    private String refundAccount;

    @Column(name = "REFUND_NAME")
    private String refundName;

    public Funding() {
    }

    public Funding(int fundingInfoNo, int projectNo, int shippingFeeNo, int memberNo, String fundingDate, int fundingAmount, int donateAmount, int rewardAmount, String fundingStatus, int refundBankCode, String refundAccount, String refundName) {
        this.fundingInfoNo = fundingInfoNo;
        this.projectNo = projectNo;
        this.shippingFeeNo = shippingFeeNo;
        this.memberNo = memberNo;
        this.fundingDate = fundingDate;
        this.fundingAmount = fundingAmount;
        this.donateAmount = donateAmount;
        this.rewardAmount = rewardAmount;
        this.fundingStatus = fundingStatus;
        this.refundBankCode = refundBankCode;
        this.refundAccount = refundAccount;
        this.refundName = refundName;
    }

    public int getFundingInfoNo() {
        return fundingInfoNo;
    }

    public void setFundingInfoNo(int fundingInfoNo) {
        this.fundingInfoNo = fundingInfoNo;
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

    public int getDonateAmount() {
        return donateAmount;
    }

    public void setDonateAmount(int donateAmount) {
        this.donateAmount = donateAmount;
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

    public int getRefundBankCode() {
        return refundBankCode;
    }

    public void setRefundBankCode(int refundBankCode) {
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

    @Override
    public String toString() {
        return "Funding{" +
                "fundingInfoNo=" + fundingInfoNo +
                ", projectNo=" + projectNo +
                ", shippingFeeNo=" + shippingFeeNo +
                ", memberNo=" + memberNo +
                ", fundingDate='" + fundingDate + '\'' +
                ", fundingAmount=" + fundingAmount +
                ", donateAmount=" + donateAmount +
                ", rewardAmount=" + rewardAmount +
                ", fundingStatus='" + fundingStatus + '\'' +
                ", refundBankCode=" + refundBankCode +
                ", refundAccount='" + refundAccount + '\'' +
                ", refundName='" + refundName + '\'' +
                '}';
    }
}