package com.greedy.dduckleaf.main.dto;

import com.greedy.dduckleaf.projectnotice.dto.ProjectNoticeDTO;

import java.util.List;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectDTO {

    private int projectNo;
    private String projectName;
    private java.sql.Date openDate;
    private java.sql.Date endDate;
    private String projectStatus;
    private int achievementRate;
    private ProjectProgressStatusDTO projectProgressStatus;
    private FarmerDTO farmer;
    private long deadLine;
}
