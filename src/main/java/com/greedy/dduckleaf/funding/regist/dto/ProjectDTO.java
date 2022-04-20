package com.greedy.dduckleaf.funding.regist.dto;

import com.greedy.dduckleaf.funding.regist.entity.ProjectShippingFee;
import com.greedy.dduckleaf.funding.regist.entity.RewardInfo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectDTO {
    private int projectNo;
    private String projectName;
    private int fundTargetAmount;
    private java.sql.Date openDate;
    private java.sql.Date endDate;
    private String projectStatus;
    private double achievementRate;
    private String examineStatus;
    private String projectExamineStatus;
    private String progressStatus;
    private int maxTargetAmount;
    private RewardInfo rewardInfo;
    private ProjectShippingFee projectShippingFee;
}
