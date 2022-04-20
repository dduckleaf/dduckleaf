package com.greedy.dduckleaf.funding.regist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "RewardInfoForFundingRegist")
@Table(name = "TBL_REWARD_REGIST_INFO")
public class RewardInfo {
    @Id
    @Column(name = "REWARD_REGIST_INFO_NO")
    private int rewardRegistInfoNo;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "REWARD_PRICE")
    private int rewardPrice;

    @Column(name = "REWARD_NAME")
    private String rewardName;

    @Column(name = "REWARD_INFO")
    private String rewardInfo;

    @Column(name = "REWARD_UNIT")
    private String rewardUnit;

    public RewardInfo() {
    }

    public RewardInfo(int rewardRegistInfoNo, int projectNo, int rewardPrice, String rewardName, String rewardInfo, String rewardUnit) {
        this.rewardRegistInfoNo = rewardRegistInfoNo;
        this.projectNo = projectNo;
        this.rewardPrice = rewardPrice;
        this.rewardName = rewardName;
        this.rewardInfo = rewardInfo;
        this.rewardUnit = rewardUnit;
    }

    public int getRewardRegistInfoNo() {
        return rewardRegistInfoNo;
    }

    public void setRewardRegistInfoNo(int rewardRegistInfoNo) {
        this.rewardRegistInfoNo = rewardRegistInfoNo;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
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

    @Override
    public String toString() {
        return "RewardInfo{" +
                "rewardRegistInfoNo=" + rewardRegistInfoNo +
                ", projectNo=" + projectNo +
                ", rewardPrice=" + rewardPrice +
                ", rewardName='" + rewardName + '\'' +
                ", rewardInfo='" + rewardInfo + '\'' +
                ", rewardUnit='" + rewardUnit + '\'' +
                '}';
    }
}
