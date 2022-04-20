package com.greedy.dduckleaf.funding.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Funding")
@Table(name = "TBL_FUNDING_INFO")
public class Funding {

    @Id
    @Column(name = "FUNDING_INFO_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fundingInfoNo;

    @Column(name = "FUNDING_DATE")
    private java.sql.Date fundingDate;

    @Column(name = "FUNDING_AMOUNT")
    private int fundingAmount;

    @Column(name = "REWARD_AMOUNT")
    private int rewardAmount;

    @Column(name = "FUNDING_STATUS")
    private String fundingStatus;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "SHIPPING_FEE_NO")
    private int shippingFeeNo;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    public Funding() {
    }

    public Funding(int fundingInfoNo, Date fundingDate, int fundingAmount, int rewardAmount, String fundingStatus, int projectNo, int shippingFeeNo, int memberNo) {
        this.fundingInfoNo = fundingInfoNo;
        this.fundingDate = fundingDate;
        this.fundingAmount = fundingAmount;
        this.rewardAmount = rewardAmount;
        this.fundingStatus = fundingStatus;
        this.projectNo = projectNo;
        this.shippingFeeNo = shippingFeeNo;
        this.memberNo = memberNo;
    }

    public int getFundingInfoNo() {
        return fundingInfoNo;
    }

    public void setFundingInfoNo(int fundingInfoNo) {
        this.fundingInfoNo = fundingInfoNo;
    }

    public Date getFundingDate() {
        return fundingDate;
    }

    public void setFundingDate(Date fundingDate) {
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

    @Override
    public String toString() {
        return "Funding{" +
                "fundingInfoNo=" + fundingInfoNo +
                ", fundingDate=" + fundingDate +
                ", fundingAmount=" + fundingAmount +
                ", rewardAmount=" + rewardAmount +
                ", fundingStatus='" + fundingStatus + '\'' +
                ", projectNo=" + projectNo +
                ", shippingFeeNo=" + shippingFeeNo +
                ", memberNo=" + memberNo +
                '}';
    }
}
