package com.greedy.dduckleaf.projectnotice.dto;

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
    private int progressStatus;
    private int farmerNo;
    private List<ProjectNoticeDTO> projectNoticeList;



}
