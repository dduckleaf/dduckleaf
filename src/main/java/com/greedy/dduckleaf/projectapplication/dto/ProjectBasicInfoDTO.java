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
    private int projectBasicCategoryNo;
    private String projectName;
    private java.sql.Date projectEndDate;
    private String projectInfo;             //프로젝트 요약
    private int projectTargetFund;
}
