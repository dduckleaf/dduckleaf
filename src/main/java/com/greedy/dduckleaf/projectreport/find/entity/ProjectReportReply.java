package com.greedy.dduckleaf.projectreport.find.entity;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity(name = "ProjectReportReply")
@Table(name = "TBL_PROJECT_REPORT_REPLY")
@DynamicInsert
public class ProjectReportReply {

    @Id
    @Column(name = "PROJECT_REPORT_REPLY_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectReportReplyNo;                       //신고답변번호

    @Column(name = "PROJECT_REPORT_REPLY_CONTENT")
    private String projectReportReplyContent;               //답변내용

    @Column(name = "PROJECT_REPORT_REPLY_DATE")
    private String projectReportReplyDate;                    //답변발신일

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_REPORT_NO")
    private ProjectReport projectReport;                    //신고번호

    @Column(name = "ADMIN_NO")
    private int adminNo;                                 //신고 답변 관리자

    @Column(name = "DELETE_YN")
    @ColumnDefault("N")
    private String deleteYn;

    public ProjectReportReply() {}

    public ProjectReportReply(int projectReportReplyNo, String projectReportReplyContent, String projectReportReplyDate,
                              ProjectReport projectReport, int adminNo, String deleteYn) {
        this.projectReportReplyNo = projectReportReplyNo;
        this.projectReportReplyContent = projectReportReplyContent;
        this.projectReportReplyDate = projectReportReplyDate;
        this.projectReport = projectReport;
        this.adminNo = adminNo;
        this.deleteYn = deleteYn;
    }

    public int getProjectReportReplyNo() {
        return projectReportReplyNo;
    }

    public void setProjectReportReplyNo(int projectReportReplyNo) {
        this.projectReportReplyNo = projectReportReplyNo;
    }

    public String getProjectReportReplyContent() {
        return projectReportReplyContent;
    }

    public void setProjectReportReplyContent(String projectReportReplyContent) {
        this.projectReportReplyContent = projectReportReplyContent;
    }

    public String getProjectReportReplyDate() {
        return projectReportReplyDate;
    }

    public void setProjectReportReplyDate(String projectReportReplyDate) {
        this.projectReportReplyDate = projectReportReplyDate;
    }

    public ProjectReport getProjectReport() {
        return projectReport;
    }

    public void setProjectReport(ProjectReport projectReport) {
        this.projectReport = projectReport;
    }

    public int getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(int adminNo) {
        this.adminNo = adminNo;
    }

    public String getDeleteYn() {
        return deleteYn;
    }

    public void setDeleteYn(String deleteYn) {
        this.deleteYn = deleteYn;
    }

    @Override
    public String toString() {
        return "ProjectReportReply{" +
                "projectReportReplyNo=" + projectReportReplyNo +
                ", projectReportReplyContent='" + projectReportReplyContent + '\'' +
                ", projectReportReplyDate=" + projectReportReplyDate +
                ", projectReport=" + projectReport +
                ", adminNo=" + adminNo +
                ", deleteYn='" + deleteYn + '\'' +
                '}';
    }
}
