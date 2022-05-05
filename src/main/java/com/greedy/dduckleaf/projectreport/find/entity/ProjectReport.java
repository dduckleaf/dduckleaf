package com.greedy.dduckleaf.projectreport.find.entity;

import javax.persistence.*;
import java.sql.Date;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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