package com.greedy.dduckleaf.settlement.calculate.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "FundingInfoForSettlement")
@Table(name = "TBL_FUNDING_INFO")
public class FundingInfo {

    @Id
    @Column(name = "FUNDING_INFO_NO")
    private int fundingInfoNo;                  //펀딩 신청내역 번호

    @Column(name = "FUNDING_AMOUNT")
    private int fundingAmount;                  //펀딩금

    @Column(name = "DONATE_AMOUNT")
    private int donateAmount;                   //후원금

    @Column(name = "FUNDING_STATUS")
    private String fundingStatus;               //펀딩상태

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_NO")
    private Project project;                    //프로젝트 번호

    @OneToMany(mappedBy = "fundingInfo")
    private List<RefundingInfo> refundingInfos;

    public FundingInfo() {}

    public FundingInfo(int fundingInfoNo, int fundingAmount, int donateAmount, String fundingStatus, Project project,
                       List<RefundingInfo> refundingInfos) {
        this.fundingInfoNo = fundingInfoNo;
        this.fundingAmount = fundingAmount;
        this.donateAmount = donateAmount;
        this.fundingStatus = fundingStatus;
        this.project = project;
        this.refundingInfos = refundingInfos;
    }

    public int getFundingInfoNo() {
        return fundingInfoNo;
    }

    public void setFundingInfoNo(int fundingInfoNo) {
        this.fundingInfoNo = fundingInfoNo;
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

    public String getFundingStatus() {
        return fundingStatus;
    }

    public void setFundingStatus(String fundingStatus) {
        this.fundingStatus = fundingStatus;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<RefundingInfo> getRefundingInfos() {
        return refundingInfos;
    }

    public void setRefundingInfos(List<RefundingInfo> refundingInfos) {
        this.refundingInfos = refundingInfos;
    }

    @Override
    public String toString() {
        return "FundingInfo{" +
                "fundingInfoNo=" + fundingInfoNo +
                ", fundingAmount=" + fundingAmount +
                ", donateAmount=" + donateAmount +
                ", fundingStatus='" + fundingStatus + '\'' +
                ", project=" + project +
                '}';
    }
}
