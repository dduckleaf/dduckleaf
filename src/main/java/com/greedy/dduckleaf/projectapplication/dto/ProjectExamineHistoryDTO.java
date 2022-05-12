package com.greedy.dduckleaf.projectapplication.dto;

public class ProjectExamineHistoryDTO {

    private int projectExamineHistoryNo;
    private ProjectExamineHistoryCategoryDTO examineHistoryCategoryNo;
    private String projectExamineDetailContent;
    private String projectExamineRegistDate;
    private ExamineProjectStatusDTO examineProjectStatusCode;
    private int farmerNo;
    private int projectNo;
    private int adminNo;

    public ProjectExamineHistoryDTO() {
    }

    public ProjectExamineHistoryDTO(int projectExamineHistoryNo, ProjectExamineHistoryCategoryDTO examineHistoryCategoryNo, String projectExamineDetailContent, String projectExamineRegistDate, ExamineProjectStatusDTO examineProjectStatusCode, int farmerNo, int projectNo, int adminNo) {
        this.projectExamineHistoryNo = projectExamineHistoryNo;
        this.examineHistoryCategoryNo = examineHistoryCategoryNo;
        this.projectExamineDetailContent = projectExamineDetailContent;
        this.projectExamineRegistDate = projectExamineRegistDate;
        this.examineProjectStatusCode = examineProjectStatusCode;
        this.farmerNo = farmerNo;
        this.projectNo = projectNo;
        this.adminNo = adminNo;
    }

    public int getProjectExamineHistoryNo() {
        return projectExamineHistoryNo;
    }

    public void setProjectExamineHistoryNo(int projectExamineHistoryNo) {
        this.projectExamineHistoryNo = projectExamineHistoryNo;
    }

    public ProjectExamineHistoryCategoryDTO getExamineHistoryCategoryNo() {
        return examineHistoryCategoryNo;
    }

    public void setExamineHistoryCategoryNo(ProjectExamineHistoryCategoryDTO examineHistoryCategoryNo) {
        this.examineHistoryCategoryNo = examineHistoryCategoryNo;
    }

    public String getProjectExamineDetailContent() {
        return projectExamineDetailContent;
    }

    public void setProjectExamineDetailContent(String projectExamineDetailContent) {
        this.projectExamineDetailContent = projectExamineDetailContent;
    }

    public String getProjectExamineRegistDate() {
        return projectExamineRegistDate;
    }

    public void setProjectExamineRegistDate(String projectExamineRegistDate) {
        this.projectExamineRegistDate = projectExamineRegistDate;
    }

    public ExamineProjectStatusDTO getExamineProjectStatusCode() {
        return examineProjectStatusCode;
    }

    public void setExamineProjectStatusCode(ExamineProjectStatusDTO examineProjectStatusCode) {
        this.examineProjectStatusCode = examineProjectStatusCode;
    }

    public int getFarmerNo() {
        return farmerNo;
    }

    public void setFarmerNo(int farmerNo) {
        this.farmerNo = farmerNo;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public int getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(int adminNo) {
        this.adminNo = adminNo;
    }

    @Override
    public String toString() {
        return "ProjectExamineHistoryDTO{" +
                "projectExamineHistoryNo=" + projectExamineHistoryNo +
                ", examineHistoryCategoryNo=" + examineHistoryCategoryNo +
                ", projectExamineDetailContent='" + projectExamineDetailContent + '\'' +
                ", projectExamineRegistDate='" + projectExamineRegistDate + '\'' +
                ", examineProjectStatusCode=" + examineProjectStatusCode +
                ", farmerNo=" + farmerNo +
                ", projectNo=" + projectNo +
                ", adminNo=" + adminNo +
                '}';
    }
}
