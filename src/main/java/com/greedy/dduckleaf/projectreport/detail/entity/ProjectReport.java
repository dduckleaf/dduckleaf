package com.greedy.dduckleaf.projectreport.detail.entity;

import javax.persistence.*;
import com.greedy.dduckleaf.projectreport.find.entity.*;

import java.sql.Date;
import java.util.List;

@Entity(name = "ProjectReportForProjectReportDetail")
@Table(name = "TBL_PROJECT_REPORT")
public class ProjectReport {

    @Id
    @Column(name = "PROJECT_REPORT_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectReportNo;

    @Column(name = "PROJECT_REPORT_DATE")
    private Date projectReportDate;

    @Transient
    @Column(name = "PROJECT_REPORT_CONTENT")
    private String projectReportContent;

    @Transient
    @Column(name = "REPORT_REF_URL")
    private String reportRefUrl;

    @Transient
    @Column(name = "REPORTER_PHONE")
    private String reporterPhone;

    @Transient
    @Column(name = "REPORTER_EMAIL")
    private String reporterEmail;

    @Transient
    @Column(name = "REPORTER_NAME")
    private String reporterName;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MEMBER_NO")
    private Member member;

    @Transient
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FARMER_NO")
    private FarmerInfo farmer;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_REPORT_CATEGORY_NO")
    private ReportCategory reportCategory;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_NO")
    private Project project;

    @Column(name = "PROJECT_REPORT_STATUS")
    private String projectReportStatus;

    @OneToMany(mappedBy = "projectReport", fetch = FetchType.EAGER)
    private List<ProjectReportReply> reportReplyList;

    public ProjectReport() {}

    public ProjectReport(int projectReportNo, Date projectReportDate, String projectReportContent, String reportRefUrl,
                         String reporterPhone, String reporterEmail, String reporterName, Member member,
                         FarmerInfo farmer, ReportCategory reportCategory, Project project, String projectReportStatus,
                         List<ProjectReportReply> reportReplyList) {
        this.projectReportNo = projectReportNo;
        this.projectReportDate = projectReportDate;
        this.projectReportContent = projectReportContent;
        this.reportRefUrl = reportRefUrl;
        this.reporterPhone = reporterPhone;
        this.reporterEmail = reporterEmail;
        this.reporterName = reporterName;
        this.member = member;
        this.farmer = farmer;
        this.reportCategory = reportCategory;
        this.project = project;
        this.projectReportStatus = projectReportStatus;
        this.reportReplyList = reportReplyList;
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public FarmerInfo getFarmer() {
        return farmer;
    }

    public void setFarmer(FarmerInfo farmer) {
        this.farmer = farmer;
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

    public List<ProjectReportReply> getReportReplyList() {
        return reportReplyList;
    }

    public void setReportReplyList(List<ProjectReportReply> reportReplyList) {
        this.reportReplyList = reportReplyList;
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
                ", farmer=" + farmer +
                ", reportCategory=" + reportCategory +
                ", project=" + project +
                ", projectReportStatus='" + projectReportStatus + '\'' +
//                ", reportReplyList=" + reportReplyList +
                '}';
    }
}
