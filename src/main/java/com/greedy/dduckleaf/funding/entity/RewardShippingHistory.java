package com.greedy.dduckleaf.funding.entity;

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
@Entity(name = "HistoryForFunding")
@Table(name = "TBL_REWARD_SHIPPING_HISTORY")
public class RewardShippingHistory {

    @Id
    @Column(name = "REWARD_SHIPPING_HISTORY_NO")
    private int rewardShippingHistoryNo;

    @Column(name = "SHIPPING_STATUS")
    private int shippingStatus;

    @Column(name = "REWARD_SHIPPING_NO")
    private int rewardShippingNo;

    @Column(name = "RECORD_DATE")
    private String recordDate;
}
