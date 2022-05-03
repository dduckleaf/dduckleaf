package com.greedy.dduckleaf.refund.regist.entity;

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
@Entity(name = "FundingForRefundingRegist")
@Table(name = "TBL_FUNDING_INFO")
public class Funding {

    @Id
    @Column(name = "FUNDING_INFO_NO")
    private int fundingInfoNo;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "SHIPPING_FEE_NO")
    private int shippingFeeNo;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "FUNDING_DATE")
    private String fundingDate;

    @Column(name = "FUNDING_AMOUNT")
    private int fundingAmount;

    @Column(name = "DONATE_AMOUNT")
    private int donateAmount;

    @Column(name = "REWARD_AMOUNT")
    private int rewardAmount;

    @Column(name = "FUNDING_STATUS")
    private String fundingStatus;

    @Column(name = "REFUND_BANK_CODE")
    private int refundBankCode;

    @Column(name = "REFUND_ACCOUNT")
    private String refundAccount;

    @Column(name = "REFUND_NAME")
    private String refundName;
}
