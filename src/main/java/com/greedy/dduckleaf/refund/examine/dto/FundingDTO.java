package com.greedy.dduckleaf.refund.examine.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class FundingDTO {

    private int fundingInfoNo;
    private String fundingDate;
    private int fundingAmount;
    private int rewardAmount;
    private String fundingStatus;
    private int donateAmount;
    private String refundName;
    private int projectNo;
    private int memberNo;
    private String extraShippingFeeStatus;
    private String refundAccount;
}
