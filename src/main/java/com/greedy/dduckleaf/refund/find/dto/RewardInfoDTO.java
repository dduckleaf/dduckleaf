package com.greedy.dduckleaf.refund.find.dto;

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
public class RewardInfoDTO {

    private int projectNo;
    private int rewardPrice;
    private String rewardName;
    private String rewardInfo;
    private String rewardUnit;
}
