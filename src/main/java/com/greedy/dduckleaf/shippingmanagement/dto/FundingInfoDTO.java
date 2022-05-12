package com.greedy.dduckleaf.shippingmanagement.dto;

import lombok.*;

public class FundingInfoDTO {

    private int fundingInfoNo;          //펀딩 신청내역 번호
    private String fundingDate;         //펀딩 신청 일자
    private int fundingAmount;          //펀딩금
    private MemberDTO member;           //회원 정보
    private int rewardAmount;           //리워드 수량
    private String fundingStatus;       //펀딩 상태
    private ProjectDTO project;         //프로젝트 정보
    private RewardShippingDTO rewardShippingList;       //리워드 발송 정보

    public FundingInfoDTO() {}

    public FundingInfoDTO(int fundingInfoNo, String fundingDate, int fundingAmount, MemberDTO member, int rewardAmount, String fundingStatus, ProjectDTO project, RewardShippingDTO rewardShippingList) {
        this.fundingInfoNo = fundingInfoNo;
        this.fundingDate = fundingDate;
        this.fundingAmount = fundingAmount;
        this.member = member;
        this.rewardAmount = rewardAmount;
        this.fundingStatus = fundingStatus;
        this.project = project;
        this.rewardShippingList = rewardShippingList;
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

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
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

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    public RewardShippingDTO getRewardShippingList() {
        return rewardShippingList;
    }

    public void setRewardShippingList(RewardShippingDTO rewardShippingList) {
        this.rewardShippingList = rewardShippingList;
    }

    @Override
    public String toString() {
        return "FundingInfoDTO{" +
                "fundingInfoNo=" + fundingInfoNo +
                ", fundingDate='" + fundingDate + '\'' +
                ", fundingAmount=" + fundingAmount +
                ", member=" + member +
                ", rewardAmount=" + rewardAmount +
                ", fundingStatus='" + fundingStatus + '\'' +
                ", project=" + project +
                ", rewardShippingList=" + rewardShippingList +
                '}';
    }
}

