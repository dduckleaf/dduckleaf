package com.greedy.dduckleaf.projectapplication.dto;

public class ProjectExamineHistoryCategoryDTO {

    private int projectExamineHistoryCategoryNo;
    private String projectExamineHistoryCategoryName;

    public ProjectExamineHistoryCategoryDTO() {
    }

    public ProjectExamineHistoryCategoryDTO(int projectExamineHistoryCategoryNo, String projectExamineHistoryCategoryName) {
        this.projectExamineHistoryCategoryNo = projectExamineHistoryCategoryNo;
        this.projectExamineHistoryCategoryName = projectExamineHistoryCategoryName;
    }

    public int getProjectExamineHistoryCategoryNo() {
        return projectExamineHistoryCategoryNo;
    }

    public void setProjectExamineHistoryCategoryNo(int projectExamineHistoryCategoryNo) {
        this.projectExamineHistoryCategoryNo = projectExamineHistoryCategoryNo;
    }

    public String getProjectExamineHistoryCategoryName() {
        return projectExamineHistoryCategoryName;
    }

    public void setProjectExamineHistoryCategoryName(String projectExamineHistoryCategoryName) {
        this.projectExamineHistoryCategoryName = projectExamineHistoryCategoryName;
    }

    @Override
    public String toString() {
        return "ProjectExamineHistoryCategoryDTO{" +
                "projectExamineHistoryCategoryNo=" + projectExamineHistoryCategoryNo +
                ", projectExamineHistoryCategoryName='" + projectExamineHistoryCategoryName + '\'' +
                '}';
    }
}
