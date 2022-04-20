package com.greedy.dduckleaf.projectreport.find.dto;

import com.greedy.dduckleaf.projectreport.find.entity.Project;

import javax.persistence.*;
import java.sql.Date;

public class ProjectReportDTO {

    private int projectReportNo;
    private Date projectReportDate;
    private String projectReportContent;
    private String reportRefUrl;
    private String reporterPhone;
    private String reporterEmail;
    private String reporterName;
    private int memberNo;
    private Project project;
    private String projectReportStatus;

    public ProjectReportDTO() {}

    public ProjectReportDTO(int projectReportNo, Date projectReportDate, String projectReportContent,
                            String reportRefUrl, String reporterPhone, String reporterEmail, String reporterName, int memberNo, Project project, String projectReportStatus) {
        this.projectReportNo = projectReportNo;
        this.projectReportDate = projectReportDate;
        this.projectReportContent = projectReportContent;
        this.reportRefUrl = reportRefUrl;
        this.reporterPhone = reporterPhone;
        this.reporterEmail = reporterEmail;
        this.reporterName = reporterName;
        this.memberNo = memberNo;
        this.project = project;
        this.projectReportStatus = projectReportStatus;
    }

    public int getProjectReportNo() {
        return projectReportNo;
    }

    public void setProjectReportNo(int projectReportNo) {
        this.projectReportNo = projectReportNo;
    }

    public Date getProjectReportDate() {
        return projectReportDate;
    }

    public void setProjectReportDate(Date projectReportDate) {
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

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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
                ", projectReportDate=" + projectReportDate +
                ", projectReportContent='" + projectReportContent + '\'' +
                ", reportRefUrl='" + reportRefUrl + '\'' +
                ", reporterPhone='" + reporterPhone + '\'' +
                ", reporterEmail='" + reporterEmail + '\'' +
                ", reporterName='" + reporterName + '\'' +
                ", memberNo=" + memberNo +
                ", project=" + project +
                ", projectReportStatus='" + projectReportStatus + '\'' +
                '}';
    }
}
