package com.greedy.dduckleaf.projectapplication.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectBasicInfoDTO {          //프로젝트 기본정보

    private int projectBasicInfoNo;
    private int projectNo;
    private ProjectRewardCategoryDTO projectRewardCategory;
    private String projectName;
    private String projectEndDate;
    private String projectInfo;             //프로젝트 요약
    private int projectTargetFund;
    private String projectPromotionAgreementStatus;
}
