package com.greedy.dduckleaf.projectreport.find.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "ProjectReport")
@Table(name = "TBL_PROJECT_REPORT")
public class ProjectReport {

    @Id
    @Column(name = "PROJECT_REPORT_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectReportNo;

    @Column(name = "PROJECT_REPORT_DATE")
    private Date projectReportDate;

    @Column(name = "PROJECT_REPORT_CONTENT")
    private String projectReportContent;

    @Column(name = "REPORT_REF_URL")
    private String reportRefUrl;

    @Column(name = "REPORTER_PHONE")
    private String reporterPhone;

    @Column(name = "REPORTER_EMAIL")
    private String reporterEmail;

    @Column(name = "REPORTER_NAME")
    private String reporterName;

//    @OneToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "MEMBER_NO")
//    private Member member;
//

    @Column(name = "MEMBER_NO")
    private int memberNo;
//
//    @JoinColumn(name = "FARMER_NO")
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    private FarmerInfo farmerInfo;
//
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "PROJECT_REPORT_CATEGORY_NO")
//    private ReportCategory reportCategory;
//
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PROJECT_NO")
    private Project project;

    @Column(name = "PROJECT_REPORT_STATUS")
    private String projectReportStatus;

    public ProjectReport() {}

    public ProjectReport(int projectReportNo, Date projectReportDate, String projectReportContent, String reportRefUrl,
                         String reporterPhone, String reporterEmail, String reporterName, int memberNo, Project project, String projectReportStatus) {
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

    public int getMember() {
        return memberNo;
    }

    public void setMember(int memberNo) {
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
        return "ProjectReport{" +
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
