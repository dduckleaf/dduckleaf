package com.greedy.dduckleaf.shippingmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "RewardShippingForShipping")
@Table(name = "TBL_REWARD_SHIPPING")
public class RewardShipping {

    @Id
    @Column(name = "REWARD_SHIPPING_NO")
    private int rewardShippingNo;

    @Column(name = "SHIPPING_DUE_DATE")
    private String shippingDueDate;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "FUNDING_INFO_NO")
    private int fundingInfoNo;

    public RewardShipping() {}
}
