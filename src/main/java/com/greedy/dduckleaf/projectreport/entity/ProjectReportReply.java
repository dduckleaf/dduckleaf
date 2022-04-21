//package com.greedy.dduckleaf.projectreport.entity;
//
//import javax.persistence.*;
//import java.sql.Date;
//
//@Entity(name = "ProjectReportReply")
//@Table(name = "TBL_PROJECT_REPORT_REPLY")
//public class ProjectReportReply {
//
//    @Id
//    @Column(name = "PROJECT_REPORT_REPLY_NO")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int projectReportReplyNo;
//
//    @JoinColumn(name = "PROJECT_REPORT_NO")
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    private ProjectReport projectReport;
//
//    @Column(name = "PROJECT_REPORT_REPLY_CONTENT")
//    private String projectReportReplyContent;
//
//    @Column(name = "PROJECT_REPORT_REPLY_DATE")
//    private Date projectReportReplyDate;
//
//    @JoinColumn(name = "ADMIN_NO")
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    private Member adminNo;
//
//    public ProjectReportReply() {}
//
//    public ProjectReportReply(int projectReportReplyNo, ProjectReport projectReport, String projectReportReplyContent,
//                              Date projectReportReplyDate, Member adminNo) {
//        this.projectReportReplyNo = projectReportReplyNo;
//        this.projectReport = projectReport;
//        this.projectReportReplyContent = projectReportReplyContent;
//        this.projectReportReplyDate = projectReportReplyDate;
//        this.adminNo = adminNo;
//    }
//
//    public int getProjectReportReplyNo() {
//        return projectReportReplyNo;
//    }
//
//    public void setProjectReportReplyNo(int projectReportReplyNo) {
//        this.projectReportReplyNo = projectReportReplyNo;
//    }
//
//    public ProjectReport getProjectReport() {
//        return projectReport;
//    }
//
//    public void setProjectReport(ProjectReport projectReport) {
//        this.projectReport = projectReport;
//    }
//
//    public String getProjectReportReplyContent() {
//        return projectReportReplyContent;
//    }
//
//    public void setProjectReportReplyContent(String projectReportReplyContent) {
//        this.projectReportReplyContent = projectReportReplyContent;
//    }
//
//    public Date getProjectReportReplyDate() {
//        return projectReportReplyDate;
//    }
//
//    public void setProjectReportReplyDate(Date projectReportReplyDate) {
//        this.projectReportReplyDate = projectReportReplyDate;
//    }
//
//    public Member getAdminNo() {
//        return adminNo;
//    }
//
//    public void setAdminNo(Member adminNo) {
//        this.adminNo = adminNo;
//    }
//
//    @Override
//    public String toString() {
//        return "ProjectReportReply{" +
//                "projectReportReplyNo=" + projectReportReplyNo +
//                ", projectReport=" + projectReport +
//                ", projectReportReplyContent='" + projectReportReplyContent + '\'' +
//                ", projectReportReplyDate=" + projectReportReplyDate +
//                ", adminNo=" + adminNo +
//                '}';
//    }
//}
