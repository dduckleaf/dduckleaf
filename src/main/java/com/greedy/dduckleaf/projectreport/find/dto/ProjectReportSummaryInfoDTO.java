package com.greedy.dduckleaf.projectreport.find.dto;

public class ProjectReportSummaryInfoDTO {

    private ProjectReportDTO projectReport;
    private ProjectDTO project;
    private ReportCategoryDTO reportCategory;

    public ProjectReportSummaryInfoDTO() {}

    public ProjectReportSummaryInfoDTO(ProjectReportDTO projectReport, ProjectDTO project, ReportCategoryDTO reportCategory) {
        this.projectReport = projectReport;
        this.project = project;
        this.reportCategory = reportCategory;
    }

    public ProjectReportDTO getProjectReport() {
        return projectReport;
    }

    public void setProjectReport(ProjectReportDTO projectReport) {
        this.projectReport = projectReport;
    }

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    public ReportCategoryDTO getReportCategory() {
        return reportCategory;
    }

    public void setReportCategory(ReportCategoryDTO reportCategory) {
        this.reportCategory = reportCategory;
    }

    @Override
    public String toString() {
        return "ProjectReportSummaryInfoDTO{" +
                "projectReport=" + projectReport +
                ", project=" + project +
                ", reportCategory=" + reportCategory +
                '}';
    }
}
