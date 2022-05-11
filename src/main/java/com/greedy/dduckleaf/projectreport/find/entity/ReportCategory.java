package com.greedy.dduckleaf.projectreport.find.entity;

import javax.persistence.*;

import java.util.List;

@Entity(name = "reportCategory")
@Table(name = "TBL_REPORT_CATEGORY")
public class ReportCategory {

    @Id
    @Column(name = "REPORT_CATEGORY_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportCategoryNo;

    @Column(name = "REPORT_CATEGORY_NAME")
    private String reportCategoryName;

    @Column(name = "REPORT_CATEGORY_CONTENT")
    private String reportCategoryContent;

    @OneToMany(mappedBy = "reportCategory", fetch=FetchType.EAGER)
    private List<ProjectReport> projectReportList;

    public ReportCategory() {}

    public ReportCategory(int reportCategoryNo, String reportCategoryName, String reportCategoryContent, List<ProjectReport> projectReportList) {
        this.reportCategoryNo = reportCategoryNo;
        this.reportCategoryName = reportCategoryName;
        this.reportCategoryContent = reportCategoryContent;
        this.projectReportList = projectReportList;
    }

    public int getReportCategoryNo() {
        return reportCategoryNo;
    }

    public void setReportCategoryNo(int reportCategoryNo) {
        this.reportCategoryNo = reportCategoryNo;
    }

    public String getReportCategoryName() {
        return reportCategoryName;
    }

    public void setReportCategoryName(String reportCategoryName) {
        this.reportCategoryName = reportCategoryName;
    }

    public String getReportCategoryContent() {
        return reportCategoryContent;
    }

    public void setReportCategoryContent(String reportCategoryContent) {
        this.reportCategoryContent = reportCategoryContent;
    }

    public List<ProjectReport> getProjectReportList() {
        return projectReportList;
    }

    public void setProjectReportList(List<ProjectReport> projectReportList) {
        this.projectReportList = projectReportList;
    }

    @Override
    public String toString() {
        return "ReportCategory{" +
                "reportCategoryNo=" + reportCategoryNo +
                ", reportCategoryName='" + reportCategoryName + '\'' +
                ", reportCategoryContent='" + reportCategoryContent + '\'' +
                '}';
    }
}
