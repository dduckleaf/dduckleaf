package com.greedy.dduckleaf.projectreport.find.entity;

import javax.persistence.*;
import java.sql.Date;
    import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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

    @Column(name = "MEMBER_NO")
    @Transient
    private int memberNo;

//    @JoinColumn(name = "FARMER_NO")
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    private FarmerInfo farmerInfo;

//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "PROJECT_REPORT_CATEGORY_NO")
//    private ReportCategory reportCategory;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PROJECT_NO")
    private Project project;

    @Column(name = "PROJECT_REPORT_STATUS")
    private String projectReportStatus;

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
