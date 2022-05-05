package com.greedy.dduckleaf.shippingmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "HistoryForShipping")
@Table(name = "TBL_REWARD_SHIPPING_HISTORY")
public class RewardShippingHistory {

    @Id
    @Column(name = "REWARD_SHIPPING_HISTORY_NO")
    private int rewardShippingHistoryNo;

    @Column(name = "SHIPPING_STATUS")
    private int shippingStatus;

    @Column(name = "REWARD_SHIPPING_NO")
    private int rewardShippingNo;

    @Column(name = "SHIP_DATE")
    private String shipDate;

    @Column(name = "DELIVERED_DATE")
    private String deliveredDate;
}
