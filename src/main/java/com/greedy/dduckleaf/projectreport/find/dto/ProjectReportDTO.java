package com.greedy.dduckleaf.projectreport.find.dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectReportDTO {
    private int projectReportNo;
    private Date projectReportDate;
    private String projectReportContent;
    private String reportRefUrl;
    private String reporterPhone;
    private String reporterEmail;
    private String reporterName;
    private int memberNo;
    private ProjectDTO project;
    private ReportCategoryDTO reportCategory;
    private String projectReportStatus;
}
