package com.greedy.dduckleaf.projectreport.find.dto;

public class ReportCategoryDTO {

    private int reportCategoryNo;
    private String reportCategoryName;
    private String reportCategoryContent;

    public ReportCategoryDTO() {}

    public ReportCategoryDTO(int reportCategoryNo, String reportCategoryName, String reportCategoryContent) {
        this.reportCategoryNo = reportCategoryNo;
        this.reportCategoryName = reportCategoryName;
        this.reportCategoryContent = reportCategoryContent;
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

    @Override
    public String toString() {
        return "ReportCategoryDTO{" +
                "reportCategoryNo=" + reportCategoryNo +
                ", reportCategoryName='" + reportCategoryName + '\'' +
                ", reportCategoryContent='" + reportCategoryContent + '\'' +
                '}';
    }
}
