package com.greedy.dduckleaf.projectapplication.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectExamineHistoryDTO {

    private int projectExamineHistoryNo;
    private ProjectExamineHistoryCategoryDTO examineHistoryCategoryNo;
    private String projectExamineDetailContent;
    private String projectExamineRegistDate;
    private ExamineProjectStatusDTO examineProjectStatusCode;
    private int farmerNo;
    private int projectNo;
    private int adminNo;
}
