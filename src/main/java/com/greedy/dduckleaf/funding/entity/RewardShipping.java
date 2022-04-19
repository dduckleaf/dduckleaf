package com.greedy.dduckleaf.funding.entity;

import javax.persistence.*;

@Entity(name = "RewardShippingForFunding")
@Table(name = "TBL_REWARD_SHIPPING")
public class RewardShipping {

    @Id
    @Column(name = "REWARD_SHIPPING_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rewardShippingNo;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "SHIPPING_DUE_DATE")
    private java.sql.Date shippingDueDate;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "FUNDING_INFO_NO")
    private int fundingInfoNo;

    @Column(name = "COMPLETE_PAYMENT_NO")
    private int completePaymentNo;


}
