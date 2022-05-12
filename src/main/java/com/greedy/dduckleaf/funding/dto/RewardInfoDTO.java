package com.greedy.dduckleaf.funding.dto;

public class RewardInfoDTO {

    private int rewardRegistInfoNo;
    private int projectNo;
    private int rewardPrice;
    private String rewardName;
    private String rewardInfo;
    private String rewardUnit;

    public RewardInfoDTO() {
    }

    public RewardInfoDTO(int rewardRegistInfoNo, int projectNo, int rewardPrice, String rewardName, String rewardInfo, String rewardUnit) {
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
        return "RewardInfoDTO{" +
                "rewardRegistInfoNo=" + rewardRegistInfoNo +
                ", projectNo=" + projectNo +
                ", rewardPrice=" + rewardPrice +
                ", rewardName='" + rewardName + '\'' +
                ", rewardInfo='" + rewardInfo + '\'' +
                ", rewardUnit='" + rewardUnit + '\'' +
                '}';
    }
}