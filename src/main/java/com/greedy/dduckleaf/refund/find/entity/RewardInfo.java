package com.greedy.dduckleaf.refund.find.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "RewardInfoForRefundingFind")
@Table(name = "TBL_REWARD_REGIST_INFO")
public class RewardInfo {


    @Id
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
}
