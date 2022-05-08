package com.greedy.dduckleaf.refund.examine.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "RewardShippingForRefundingFarmerExamine")
@Table(name = "TBL_REWARD_SHIPPING")
public class RewardShipping {

    @Id
    @Column(name = "REWARD_SHIPPING_NO")
    private int rewardShippingNo;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FUNDING_INFO_NO")
    private Funding funding;

    @Column(name = "SHIPPING_DUE_DATE")
    private String shippingDueDate;
}




