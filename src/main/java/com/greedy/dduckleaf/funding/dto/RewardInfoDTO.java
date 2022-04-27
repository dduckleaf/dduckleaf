package com.greedy.dduckleaf.funding.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RewardInfoDTO {

    private int rewardRegistInfoNo;
    private int projectNo;
    private int rewardPrice;
    private String rewardName;
    private String rewardInfo;
    private String rewardUnit;
}
