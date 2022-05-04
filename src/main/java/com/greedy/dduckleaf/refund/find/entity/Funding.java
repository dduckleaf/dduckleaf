package com.greedy.dduckleaf.refund.find.entity;

import com.greedy.dduckleaf.funding.entity.Bank;
import com.greedy.dduckleaf.funding.entity.Project;
import com.greedy.dduckleaf.funding.entity.ProjectShippingFee;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "FundingForRefundingFind")
@Table(name = "TBL_FUNDING_INFO")
public class Funding {

    @Id
    @Column(name = "FUNDING_INFO_NO")
    private int fundingInfoNo;

    @Column(name = "FUNDING_DATE")
    private String fundingDate;

    @Column(name = "FUNDING_AMOUNT")
    private int fundingAmount;

    @Column(name = "REWARD_AMOUNT")
    private int rewardAmount;

    @Column(name = "FUNDING_STATUS")
    private String fundingStatus;

    @Column(name = "DONATE_AMOUNT")
    private int donateAmount;

    @Column(name = "REFUND_NAME")
    private String refundName;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "EXTRA_SHIPPING_FEE_STATUS")
    private String extraShippingFeeStatus;

    @Column(name = "REFUND_ACCOUNT")
    private int refundAccount;
}
