package com.greedy.dduckleaf.shippingmanagement.entity;

import javax.persistence.*;

import java.util.List;

@Entity(name = "ShippingForFundingInfo")
@Table(name = "TBL_FUNDING_INFO")
public class FundingInfo {

    @Id
    @Column(name = "FUNDING_INFO_NO")
    private int fundingInfoNo;              //펀딩 신청내역 번호

    @Column(name = "FUNDING_DATE")
    private String fundingDate;             //펀딩 신청 일자

    @Column(name = "FUNDING_AMOUNT")
    private int fundingAmount;              //펀딩금

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MEMBER_NO")
    private Member member;                  //회원 엔티티 N:1 매핑

    @Column(name = "REWARD_AMOUNT")
    private int rewardAmount;               //리워드 수량

    @Column(name = "FUNDING_STATUS")
    private String fundingStatus;           //펀딩 상태

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PROJECT_NO")
    private Project project;                //프로젝트 엔티티 N:1 매핑

    @OneToMany(mappedBy = "fundingInfo", fetch = FetchType.EAGER)
    private List<RewardShipping> rewardShippingList;    //리워드 발송 정보 1:N 매핑

    @OneToOne(mappedBy = "fundingInfo", fetch = FetchType.EAGER)
    private ShippingAddress shippingAddress;            //배송지 정보 1:N 매핑

    public FundingInfo() {}

    public FundingInfo(int fundingInfoNo, String fundingDate, int fundingAmount, Member member, int rewardAmount, String fundingStatus, Project project, List<RewardShipping> rewardShippingList, ShippingAddress shippingAddress) {
        this.fundingInfoNo = fundingInfoNo;
        this.fundingDate = fundingDate;
        this.fundingAmount = fundingAmount;
        this.member = member;
        this.rewardAmount = rewardAmount;
        this.fundingStatus = fundingStatus;
        this.project = project;
        this.rewardShippingList = rewardShippingList;
        this.shippingAddress = shippingAddress;
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<RewardShipping> getRewardShippingList() {
        return rewardShippingList;
    }

    public void setRewardShippingList(List<RewardShipping> rewardShippingList) {
        this.rewardShippingList = rewardShippingList;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public String toString() {
        return "FundingInfo{" +
                "fundingInfoNo=" + fundingInfoNo +
                ", fundingDate='" + fundingDate + '\'' +
                ", fundingAmount=" + fundingAmount +
                ", member=" + member +
                ", rewardAmount=" + rewardAmount +
                ", fundingStatus='" + fundingStatus + '\'' +
                ", project=" + project +
                ", rewardShippingList=" + rewardShippingList +
                ", shippingAddress=" + shippingAddress +
                '}';
    }
}
