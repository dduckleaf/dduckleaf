package com.greedy.dduckleaf.refund.find.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectDTO {

    private int projectNo;
    private String projectName;
    private RewardInfoDTO rewardInfo;
    private ProjectProgressStatusDTO progressStatus;
}
