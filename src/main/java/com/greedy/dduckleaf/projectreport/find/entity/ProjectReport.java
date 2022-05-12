package com.greedy.dduckleaf.projectreport.find.entity;

import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;

@Entity(name = "ProjectReport")
@Table(name = "TBL_PROJECT_REPORT")
@DynamicInsert
public class ProjectReport {

    @Id
    @Column(name = "PROJECT_REPORT_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectReportNo;

    @Column(name = "PROJECT_REPORT_DATE")
    private String projectReportDate;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MEMBER_NO")
    private Member member;

//    @Transient
//    @OneToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "FARMER_NO")
//    private FarmerInfo farmer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_REPORT_CATEGORY_NO")
    private ReportCategory reportCategory;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_NO")
    private Project project;

    @Column(name = "PROJECT_REPORT_STATUS")
    private String projectReportStatus;

    @Column(name = "DELETE_YN")
    private String deleteYn;

    public ProjectReport() {}

    public ProjectReport(int projectReportNo, String projectReportDate, String projectReportContent, String reportRefUrl,
                         String reporterPhone, String reporterEmail, String reporterName, Member member,
                         ReportCategory reportCategory, Project project, String projectReportStatus, String deleteYn) {
        this.projectReportNo = projectReportNo;
        this.projectReportDate = projectReportDate;
        this.projectReportContent = projectReportContent;
        this.reportRefUrl = reportRefUrl;
        this.reporterPhone = reporterPhone;
        this.reporterEmail = reporterEmail;
        this.reporterName = reporterName;
        this.member = member;
        this.reportCategory = reportCategory;
        this.project = project;
        this.projectReportStatus = projectReportStatus;
        this.deleteYn = deleteYn;
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public ReportCategory getReportCategory() {
        return reportCategory;
    }

    public void setReportCategory(ReportCategory reportCategory) {
        this.reportCategory = reportCategory;
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

    public String getDeleteYn() {
        return deleteYn;
    }

    public void setDeleteYn(String deleteYn) {
        this.deleteYn = deleteYn;
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
                ", member=" + member +
//                ", farmer=" + farmer +
                ", reportCategory=" + reportCategory +
                ", project=" + project +
                ", projectReportStatus='" + projectReportStatus + '\'' +
                ", deleteYn='" + deleteYn + '\'' +
                '}';
    }
}