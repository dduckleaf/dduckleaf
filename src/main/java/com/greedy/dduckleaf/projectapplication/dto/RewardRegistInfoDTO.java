package com.greedy.dduckleaf.projectapplication.dto;

public class RewardRegistInfoDTO {          //리워드 등록 정보

    private int rewardRegistInfoNo;
    private String rewardPreparingStatus;   //리워드 준비상태
    private String rewardDeliveryPlan;      //리워드 전달계획
    private int rewardPrice;                //리워드 가격
    private String rewardName;              //리워드 명
    private String rewardInfo;              //리워드 소개
    private String rewardUnit;              //리워드 단위
    private int projectNo;
    private String rewardAgreementStatus;
    private String rewardAgreementDate;

    public RewardRegistInfoDTO() {
    }

    public RewardRegistInfoDTO(int rewardRegistInfoNo, String rewardPreparingStatus, String rewardDeliveryPlan, int rewardPrice, String rewardName, String rewardInfo, String rewardUnit, int projectNo, String rewardAgreementStatus, String rewardAgreementDate) {
        this.rewardRegistInfoNo = rewardRegistInfoNo;
        this.rewardPreparingStatus = rewardPreparingStatus;
        this.rewardDeliveryPlan = rewardDeliveryPlan;
        this.rewardPrice = rewardPrice;
        this.rewardName = rewardName;
        this.rewardInfo = rewardInfo;
        this.rewardUnit = rewardUnit;
        this.projectNo = projectNo;
        this.rewardAgreementStatus = rewardAgreementStatus;
        this.rewardAgreementDate = rewardAgreementDate;
    }

    public int getRewardRegistInfoNo() {
        return rewardRegistInfoNo;
    }

    public void setRewardRegistInfoNo(int rewardRegistInfoNo) {
        this.rewardRegistInfoNo = rewardRegistInfoNo;
    }

    public String getRewardPreparingStatus() {
        return rewardPreparingStatus;
    }

    public void setRewardPreparingStatus(String rewardPreparingStatus) {
        this.rewardPreparingStatus = rewardPreparingStatus;
    }

    public String getRewardDeliveryPlan() {
        return rewardDeliveryPlan;
    }

    public void setRewardDeliveryPlan(String rewardDeliveryPlan) {
        this.rewardDeliveryPlan = rewardDeliveryPlan;
    }

    public int getRewardPrice() {
        return rewardPrice;
    }

    public void setRewardPrice(int rewardPrice) {
        this.rewardPrice = rewardPrice;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getRewardInfo() {
        return rewardInfo;
    }

    public void setRewardInfo(String rewardInfo) {
        this.rewardInfo = rewardInfo;
    }

    public String getRewardUnit() {
        return rewardUnit;
    }

    public void setRewardUnit(String rewardUnit) {
        this.rewardUnit = rewardUnit;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getRewardAgreementStatus() {
        return rewardAgreementStatus;
    }

    public void setRewardAgreementStatus(String rewardAgreementStatus) {
        this.rewardAgreementStatus = rewardAgreementStatus;
    }

    public String getRewardAgreementDate() {
        return rewardAgreementDate;
    }

    public void setRewardAgreementDate(String rewardAgreementDate) {
        this.rewardAgreementDate = rewardAgreementDate;
    }

    @Override
    public String toString() {
        return "RewardRegistInfoDTO{" +
                "rewardRegistInfoNo=" + rewardRegistInfoNo +
                ", rewardPreparingStatus='" + rewardPreparingStatus + '\'' +
                ", rewardDeliveryPlan='" + rewardDeliveryPlan + '\'' +
                ", rewardPrice=" + rewardPrice +
                ", rewardName='" + rewardName + '\'' +
                ", rewardInfo='" + rewardInfo + '\'' +
                ", rewardUnit='" + rewardUnit + '\'' +
                ", projectNo=" + projectNo +
                ", rewardAgreementStatus='" + rewardAgreementStatus + '\'' +
                ", rewardAgreementDate='" + rewardAgreementDate + '\'' +
                '}';
    }
}
