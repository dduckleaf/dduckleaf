package com.greedy.dduckleaf.projectapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "RewardRegistInfo")
@Table(name = "TBL_REWARD_REGIST_INFO")
public class RewardRegistInfo {

    @Id
    @Column(name = "REWARD_REGIST_INFO_NO")
    private int rewardRegistInfoNo;

    @Column(name = "REWARD_PREPARING_STATUS")
    private String rewardPreparingStatus;   //리워드 준비상태

    @Column(name = "REWARD_DELIVERY_PLAN")
    private String rewardDeliveryPlan;      //리워드 전달계획

    @Column(name = "REWARD_PRICE")
    private int rewardPrice;                //리워드 가격

    @Column(name = "REWARD_NAME")
    private String rewardName;              //리워드 명

    @Column(name = "REWARD_INFO")
    private String rewardInfo;              //리워드 소개

    @Column(name = "REWARD_UNIT")
    private String rewardUnit;              //리워드 단위

    @ManyToOne
    @JoinColumn(name = "PROJECT_NO")
    private Project projectNo;

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
                '}';
    }
}
