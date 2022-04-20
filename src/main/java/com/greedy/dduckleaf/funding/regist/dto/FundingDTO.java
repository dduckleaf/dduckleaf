package com.greedy.dduckleaf.funding.regist.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class FundingDTO {
    private int fundingInfoNo;
    private java.sql.Date fundingDate;
    private int fundingAmount;
    private int rewardAmount;
    private String fundingStatus;
    private int projectNo;
    private int shippingFeeNo;
    private int memberNo;

}
