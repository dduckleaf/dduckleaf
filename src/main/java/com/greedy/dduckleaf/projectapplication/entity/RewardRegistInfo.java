package com.greedy.dduckleaf.projectapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "RewardRegistInfo")
@Table(name = "TBL_REWARD_REGIST_INFO")
@DynamicInsert
public class RewardRegistInfo {

    @Id
    @Column(name = "REWARD_REGIST_INFO_NO")
    private int rewardRegistInfoNo;

    @Column(name = "REWARD_PREPARING_STATUS")
//    @ColumnDefault("준비")
    private String rewardPreparingStatus;   //리워드 준비상태

    @Column(name = "REWARD_DELIVERY_PLAN")
//    @ColumnDefault("리워드 전달계획을 작성해주세요")
    private String rewardDeliveryPlan;      //리워드 전달계획

    @Column(name = "REWARD_PRICE")
//    @ColumnDefault("0")
    private int rewardPrice;                //리워드 가격

    @Column(name = "REWARD_NAME")
//    @ColumnDefault("리워드 명")
    private String rewardName;              //리워드 명

    @Column(name = "REWARD_INFO")
//    @ColumnDefault("리워드 소개를 간단히 적어주세요")
    private String rewardInfo;              //리워드 소개

    @Column(name = "REWARD_UNIT")
//    @ColumnDefault("리워드 단위")
    private String rewardUnit;              //리워드 단위

//    @ManyToOne
    @Column(name = "PROJECT_NO")
    private int projectNo;

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

    @PrePersist
    public void prePersist() {

        this.rewardPreparingStatus = this.rewardPreparingStatus  == null ? "준비" : this.rewardPreparingStatus ;
        this.rewardDeliveryPlan = this.rewardDeliveryPlan  == null ? "리워드 전달계획을 작성해주세요" : this.rewardDeliveryPlan ;
        this.rewardName = this.rewardName  == null ? "리워드 명" : this.rewardName ;
        this.rewardInfo = this.rewardInfo  == null ? "리워드 소개를 간단히 적어주세요" : this.rewardInfo ;
        this.rewardUnit = this.rewardUnit  == null ? "리워드 단위" : this.rewardUnit ;

    }
}
