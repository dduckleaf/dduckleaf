package com.greedy.dduckleaf.funding.dto;

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
    private int projectNo;
    private int shippingFeeNo;
    private int memberNo;
    private String rewardCategoryName;
    private ProjectDTO project;

}
