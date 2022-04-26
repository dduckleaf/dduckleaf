package com.greedy.dduckleaf.funding.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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
