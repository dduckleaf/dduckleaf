package com.greedy.dduckleaf.funding.dto;

import com.greedy.dduckleaf.funding.entity.ProjectRegistInfo;
import com.greedy.dduckleaf.funding.entity.ProjectShippingFee;
import com.greedy.dduckleaf.funding.entity.RewardInfo;

import lombok.*;

import java.util.List;

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
    private RewardInfoDTO rewardInfo;
    private ProjectShippingFeeDTO projectShippingFee;
    private List<ProjectRegistInfoDTO> registInfo;
}
