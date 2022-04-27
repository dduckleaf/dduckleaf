package com.greedy.dduckleaf.projectapplication.dto;

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
    private int progressStatus;
    private String examineStatus;
    private String projectExamineStatus;
    private int maxTargetAmount;
    private int farmerNo;

}
