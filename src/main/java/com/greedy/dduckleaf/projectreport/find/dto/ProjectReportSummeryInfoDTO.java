package com.greedy.dduckleaf.projectreport.find.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectReportSummeryInfoDTO {

    private ProjectReportDTO projectReport;
    private ProjectDTO project;
    private ReportCategoryDTO reportCategory;
}
