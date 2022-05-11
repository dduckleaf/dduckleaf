package com.greedy.dduckleaf.funding.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FundingByMemberForAdminDTO {

    private int fundingNo;
    private String projectName;
    private int fundingAmount;
    private int donate;
    private String reward;
    private String rewardCount;
    private int shippingFee;
    private String date;
}
