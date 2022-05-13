package com.greedy.dduckleaf.funding.entity;

import javax.persistence.*;

import lombok.*;

@Entity(name = "Funding")
@Table(name = "TBL_FUNDING_INFO")
public class Funding {

    @Id
    @Column(name = "FUNDING_INFO_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "PROJECT_NO")
    private Project project;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "SHIPPING_FEE_NO")
    private ProjectShippingFee projectShippingFee;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "EXTRA_SHIPPING_FEE_STATUS")
    private String extraShippingFeeStatus;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "REFUND_BANK_CODE")
    private Bank refundBankCode;

    public Funding() {
    }

    public Funding(int fundingInfoNo, String fundingDate, int fundingAmount, int rewardAmount, String fundingStatus, int donateAmount, String refundName, Project project, ProjectShippingFee projectShippingFee, int memberNo, String extraShippingFeeStatus, Bank refundBankCode, int refundAccount) {
        this.fundingInfoNo = fundingInfoNo;
        this.fundingDate = fundingDate;
        this.fundingAmount = fundingAmount;
        this.rewardAmount = rewardAmount;
        this.fundingStatus = fundingStatus;
        this.donateAmount = donateAmount;
        this.refundName = refundName;
        this.project = project;
        this.projectShippingFee = projectShippingFee;
        this.memberNo = memberNo;
        this.extraShippingFeeStatus = extraShippingFeeStatus;
        this.refundBankCode = refundBankCode;
        this.refundAccount = refundAccount;
    }

    @Column(name = "REFUND_ACCOUNT")
    private int refundAccount;

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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public ProjectShippingFee getProjectShippingFee() {
        return projectShippingFee;
    }

    public void setProjectShippingFee(ProjectShippingFee projectShippingFee) {
        this.projectShippingFee = projectShippingFee;
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

    public Bank getRefundBankCode() {
        return refundBankCode;
    }

    public void setRefundBankCode(Bank refundBankCode) {
        this.refundBankCode = refundBankCode;
    }

    public int getRefundAccount() {
        return refundAccount;
    }

    public void setRefundAccount(int refundAccount) {
        this.refundAccount = refundAccount;
    }

    @Override
    public String toString() {
        return "Funding{" +
                "fundingInfoNo=" + fundingInfoNo +
                ", fundingDate=" + fundingDate +
                ", fundingAmount=" + fundingAmount +
                ", rewardAmount=" + rewardAmount +
                ", fundingStatus='" + fundingStatus + '\'' +
                ", donateAmount=" + donateAmount + "\n" +
                ", project=" + project + "\n" +
                ", projectShippingFee=" + projectShippingFee + "\n" +
                ", memberNo=" + memberNo +
                ", extraShippingFeeStatus='" + extraShippingFeeStatus + '\'' +
                ", refundBankCode=" + refundBankCode +
                ", refundAccount=" + refundAccount +
                '}';
    }
}
