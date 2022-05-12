package com.greedy.dduckleaf.funding.dto;

public class ProjectRewardCategoryDTO {

    private int projectCategoryNo;
    private String projectCategoryName;

    public ProjectRewardCategoryDTO() {
    }

    public ProjectRewardCategoryDTO(int projectCategoryNo, String projectCategoryName) {
        this.projectCategoryNo = projectCategoryNo;
        this.projectCategoryName = projectCategoryName;
    }

    public int getProjectCategoryNo() {
        return projectCategoryNo;
    }

    public void setProjectCategoryNo(int projectCategoryNo) {
        this.projectCategoryNo = projectCategoryNo;
    }

    public String getProjectCategoryName() {
        return projectCategoryName;
    }

    public void setProjectCategoryName(String projectCategoryName) {
        this.projectCategoryName = projectCategoryName;
    }

    @Override
    public String toString() {
        return "ProjectRewardCategoryDTO{" +
                "projectCategoryNo=" + projectCategoryNo +
                ", projectCategoryName='" + projectCategoryName + '\'' +
                '}';
    }
}
