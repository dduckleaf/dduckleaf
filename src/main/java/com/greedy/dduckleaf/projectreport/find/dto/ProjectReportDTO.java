package com.greedy.dduckleaf.projectreport.find.dto;

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

    public ProjectReportDTO() {}

    public ProjectReportDTO(int projectReportNo, String projectReportDate, String projectReportContent,
                            String reportRefUrl, String reporterPhone, String reporterEmail, String reporterName,
                            MemberDTO member, ProjectDTO project, ReportCategoryDTO reportCategory, String projectReportStatus) {
        this.projectReportNo = projectReportNo;
        this.projectReportDate = projectReportDate;
        this.projectReportContent = projectReportContent;
        this.reportRefUrl = reportRefUrl;
        this.reporterPhone = reporterPhone;
        this.reporterEmail = reporterEmail;
        this.reporterName = reporterName;
        this.member = member;
        this.project = project;
        this.reportCategory = reportCategory;
        this.projectReportStatus = projectReportStatus;
    }

    public int getProjectReportNo() {
        return projectReportNo;
    }

    public void setProjectReportNo(int projectReportNo) {
        this.projectReportNo = projectReportNo;
    }

    public String getProjectReportDate() {
        return projectReportDate;
    }

    public void setProjectReportDate(String projectReportDate) {
        this.projectReportDate = projectReportDate;
    }

    public String getProjectReportContent() {
        return projectReportContent;
    }

    public void setProjectReportContent(String projectReportContent) {
        this.projectReportContent = projectReportContent;
    }

    public String getReportRefUrl() {
        return reportRefUrl;
    }

    public void setReportRefUrl(String reportRefUrl) {
        this.reportRefUrl = reportRefUrl;
    }

    public String getReporterPhone() {
        return reporterPhone;
    }

    public void setReporterPhone(String reporterPhone) {
        this.reporterPhone = reporterPhone;
    }

    public String getReporterEmail() {
        return reporterEmail;
    }

    public void setReporterEmail(String reporterEmail) {
        this.reporterEmail = reporterEmail;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
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

    public String getProjectReportStatus() {
        return projectReportStatus;
    }

    public void setProjectReportStatus(String projectReportStatus) {
        this.projectReportStatus = projectReportStatus;
    }

    @Override
    public String toString() {
        return "ProjectReportDTO{" +
                "projectReportNo=" + projectReportNo +
                ", projectReportDate='" + projectReportDate + '\'' +
                ", projectReportContent='" + projectReportContent + '\'' +
                ", reportRefUrl='" + reportRefUrl + '\'' +
                ", reporterPhone='" + reporterPhone + '\'' +
                ", reporterEmail='" + reporterEmail + '\'' +
                ", reporterName='" + reporterName + '\'' +
                ", member=" + member +
                ", project=" + project +
                ", reportCategory=" + reportCategory +
                ", projectReportStatus='" + projectReportStatus + '\'' +
                '}';
    }
}