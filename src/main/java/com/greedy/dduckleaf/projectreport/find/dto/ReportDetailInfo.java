package com.greedy.dduckleaf.projectreport.find.dto;

public class ReportDetailInfo {

    private ProjectReportDTO projectReport;
    private ProjectReportReplyDTO projectReportReply;

    public ReportDetailInfo() {}

    public ReportDetailInfo(ProjectReportDTO projectReport, ProjectReportReplyDTO projectReportReply) {
        this.projectReport = projectReport;
        this.projectReportReply = projectReportReply;
    }

    public ProjectReportDTO getProjectReport() {
        return projectReport;
    }

    public void setProjectReport(ProjectReportDTO projectReport) {
        this.projectReport = projectReport;
    }

    public ProjectReportReplyDTO getProjectReportReply() {
        return projectReportReply;
    }

    public void setProjectReportReply(ProjectReportReplyDTO projectReportReply) {
        this.projectReportReply = projectReportReply;
    }

    @Override
    public String toString() {
        return "ReportDetailInfo{" +
                "projectReport=" + projectReport +
                ", projectReportReply=" + projectReportReply +
                '}';
    }
}
