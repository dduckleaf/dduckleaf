package com.greedy.dduckleaf.projectreport.find.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectReportSummaryInfoDTO {

    private ProjectReportDTO projectReport;
    private ProjectDTO project;
    private ReportCategoryDTO reportCategory;
}
