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
    private String projectReportDate;
    private String projectReportContent;
    private String reportRefUrl;
    private String reporterPhone;
    private String reporterEmail;
    private String reporterName;
    private MemberDTO member;
    private ProjectDTO project;
    private ReportCategoryDTO reportCategory;
    private String projectReportStatus;
}