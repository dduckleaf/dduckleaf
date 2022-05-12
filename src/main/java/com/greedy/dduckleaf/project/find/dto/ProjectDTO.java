package com.greedy.dduckleaf.project.find.dto;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
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
    private Date openDate;
    private Date endDate;
    private String projectStatus;
    private double achievementRate;
    private String examineStatus;
    private String projectExamineStatus;
    private ProjectProgressStatusDTO progressStatus;
    private int maxTargetAmount;
    private MemberDTO farmer;
    private ProjectRewardCategoryDTO reward;
    private String timeInfo;
    private String imagePath;
}
