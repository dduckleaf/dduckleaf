package com.greedy.dduckleaf.projectreport.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "ReportCategory")
@Table(name = "TBL_REPORT_CATEGORY")
public class ProjectReportCategory {

    @Id
    @Column(name = "REPORT_CATEGORY_NO")
    private int reportCategoryNo;

    @Column(name = "REPORT_CATEGORY_NAME")
    private String reportCategoryName;

    @Column(name = "REPORT_CATEGORY_CONTENT")
    private String reportCategoryContent;

    @OneToMany(mappedBy = "")
    private List<ProjectReport> reportList;

    public ProjectReportCategory() {}

    public ProjectReportCategory(int reportCategoryNo, String reportCategoryName, String reportCategoryContent,
                    List<ProjectReport> reportList) {
        this.reportCategoryNo = reportCategoryNo;
        this.reportCategoryName = reportCategoryName;
        this.reportCategoryContent = reportCategoryContent;
        this.reportList = reportList;
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

    public List<ProjectReport> getReportList() {
        return reportList;
    }

    public void setReportList(List<ProjectReport> reportList) {
        this.reportList = reportList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "reportCategoryNo=" + reportCategoryNo +
                ", reportCategoryName='" + reportCategoryName + '\'' +
                ", reportCategoryContent='" + reportCategoryContent + '\'' +
//                ", reportList=" + reportList +
                '}';
    }
}
