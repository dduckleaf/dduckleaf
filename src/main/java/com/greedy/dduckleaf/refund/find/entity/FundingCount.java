package com.greedy.dduckleaf.refund.find.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "FundingCountForAdminRefundingFind")
@Table(name = "TBL_FUNDING_INFO")
public class FundingCount {

    @Id
    @Column(name = "FUNDING_INFO_NO")
    private int fundingInfoNo;

    @Column(name = "FUNDING_DATE")
    private String fundingDate;

    @Column(name = "FUNDING_AMOUNT")
    private int fundingAmount;

    @Column(name = "REWARD_AMOUNT")
    private int rewardAmount;

    @Column(name = "FUNDING_STATUS")
    private String fundingStatus;

    @Column(name = "DONATE_AMOUNT")
    private int donateAmount;

    @Column(name = "REFUND_NAME")
    private String refundName;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "EXTRA_SHIPPING_FEE_STATUS")
    private String extraShippingFeeStatus;

    @Column(name = "REFUND_ACCOUNT")
    private String refundAccount;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FUNDING_INFO_NO")
    private List<RefundingCount> refundings;

    public FundingCount() {
    }

    public FundingCount(int fundingInfoNo, String fundingDate, int fundingAmount, int rewardAmount, String fundingStatus, int donateAmount, String refundName, int projectNo, int memberNo, String extraShippingFeeStatus, String refundAccount, List<RefundingCount> refundings) {
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
        this.refundings = refundings;
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

    public List<RefundingCount> getRefundings() {
        return refundings;
    }

    public void setRefundings(List<RefundingCount> refundings) {
        this.refundings = refundings;
    }

    @Override
    public String toString() {
        return "FundingCount{" +
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