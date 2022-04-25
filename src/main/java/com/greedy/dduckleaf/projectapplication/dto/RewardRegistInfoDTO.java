package com.greedy.dduckleaf.projectapplication.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RewardRegistInfoDTO {          //리워드 등록 정보

    private int rewardRegistInfoNo;
    private String rewardPreparingStatus;   //리워드 준비상태
    private String rewardDeliveryPlan;      //리워드 전달계획
    private int rewardPrice;                //리워드 가격
    private String rewardName;              //리워드 명
    private String rewardInfo;              //리워드 소개
    private String rewardUnit;              //리워드 단위
    private int projectNo;
}
