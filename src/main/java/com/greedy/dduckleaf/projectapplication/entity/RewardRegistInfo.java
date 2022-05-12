package com.greedy.dduckleaf.projectapplication.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "RewardRegistInfo")
@Table(name = "TBL_REWARD_REGIST_INFO")
@DynamicInsert
public class RewardRegistInfo {

    @Id
    @Column(name = "REWARD_REGIST_INFO_NO")
    private int rewardRegistInfoNo;

    @Column(name = "REWARD_PREPARING_STATUS")
    private String rewardPreparingStatus;       //리워드 준비상태

    @Column(name = "REWARD_DELIVERY_PLAN")
    private String rewardDeliveryPlan;          //리워드 전달계획

    @Column(name = "REWARD_PRICE")
    private int rewardPrice;                    //리워드 가격

    @Column(name = "REWARD_NAME")
    private String rewardName;                  //리워드 명

    @Column(name = "REWARD_INFO")
    private String rewardInfo;                  //리워드 소개

    @Column(name = "REWARD_UNIT")
    private String rewardUnit;                  //리워드 단위

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "REWARD_AGREEMENT_STATUS")
    private String rewardAgreementStatus;

    @Column(name = "REWARD_AGREEMENT_DATE")
    private String rewardAgreementDate;

    public RewardRegistInfo() {
    }

    public RewardRegistInfo(int rewardRegistInfoNo, String rewardPreparingStatus, String rewardDeliveryPlan, int rewardPrice, String rewardName, String rewardInfo, String rewardUnit, int projectNo, String rewardAgreementStatus, String rewardAgreementDate) {
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
        return "RewardRegistInfo{" +
                "rewardRegistInfoNo=" + rewardRegistInfoNo +
                ", rewardPreparingStatus='" + rewardPreparingStatus + '\'' +
                ", rewardDeliveryPlan='" + rewardDeliveryPlan + '\'' +
                ", rewardPrice=" + rewardPrice +
                ", rewardName='" + rewardName + '\'' +
                ", rewardInfo='" + rewardInfo + '\'' +
                ", rewardUnit='" + rewardUnit + '\'' +
                ", projectNo=" + projectNo +
                ", rewardAgreementStatus='" + rewardAgreementStatus + '\'' +
                ", rewardAgreementDate=" + rewardAgreementDate +
                '}';
    }

    @PrePersist
    public void prePersist() {

        this.rewardPreparingStatus = this.rewardPreparingStatus  == null ? "준비" : this.rewardPreparingStatus ;
        this.rewardDeliveryPlan = this.rewardDeliveryPlan  == null ? "리워드 전달계획을 작성해주세요" : this.rewardDeliveryPlan ;
        this.rewardName = this.rewardName  == null ? "리워드 명" : this.rewardName ;
        this.rewardInfo = this.rewardInfo  == null ? "리워드 소개를 간단히 적어주세요" : this.rewardInfo ;
        this.rewardUnit = this.rewardUnit  == null ? "리워드 단위" : this.rewardUnit ;
        this.rewardAgreementDate = this.rewardAgreementDate  == null ? java.sql.Date.valueOf(LocalDate.now()).toString() : this.rewardAgreementDate ;

    }
}
