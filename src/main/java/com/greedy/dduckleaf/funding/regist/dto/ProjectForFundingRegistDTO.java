package com.greedy.dduckleaf.funding.regist.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectForFundingRegistDTO {
    private int projectNo;
    private String projectName;
    private java.util.Date endDate;
    private RewardInfoDTO rewardInfo;
    private ProjectShippingFeeDTO projectShippingFee;

}
