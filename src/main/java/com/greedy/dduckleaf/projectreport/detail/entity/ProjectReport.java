package com.greedy.dduckleaf.projectreport.detail.entity;

import javax.persistence.*;

import com.greedy.dduckleaf.projectreport.find.entity.*;
import com.greedy.dduckleaf.projectreport.find.entity.Member;
import com.greedy.dduckleaf.projectreport.find.entity.Project;
import com.greedy.dduckleaf.projectreport.find.entity.ReportCategory;
import lombok.*;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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
    List<ProjectReportReply> reportReplyList;

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
                ", project=" + project +
                ", projectReportStatus='" + projectReportStatus + '\'' +
                '}';
    }
}
