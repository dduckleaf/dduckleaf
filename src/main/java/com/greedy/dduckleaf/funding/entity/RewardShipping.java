package com.greedy.dduckleaf.funding.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "RewardShippingForFundingInfo")
@Table(name = "TBL_REWARD_SHIPPING")
public class RewardShipping {

    @Id
    @Column(name = "REWARD_SHIPPING_NO")
    private int rewardShippingNo;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "FUNDING_INFO_NO")
    private int fundingInfoNo;

    @Column(name = "COMPLETE_PAYMENT_NO")
    private int completePaymentNo;

    @Column(name = "SHIPPING_DUE_DATE")
    private java.sql.Date shippingDueDate;
}




