package com.greedy.dduckleaf.refund.examine.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RewardInfoDTO {

    private int projectNo;
    private int rewardPrice;
    private String rewardName;
    private String rewardInfo;
    private String rewardUnit;
}
