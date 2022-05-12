package com.greedy.dduckleaf.funding.dto;

public class ProjectBasicInfoDTO {

    private int projectRegistInfoNo;
    private ProjectRewardCategoryDTO category;

    public ProjectBasicInfoDTO() {
    }

    public ProjectBasicInfoDTO(int projectRegistInfoNo, ProjectRewardCategoryDTO category) {
        this.projectRegistInfoNo = projectRegistInfoNo;
        this.category = category;
    }

    public int getProjectRegistInfoNo() {
        return projectRegistInfoNo;
    }

    public void setProjectRegistInfoNo(int projectRegistInfoNo) {
        this.projectRegistInfoNo = projectRegistInfoNo;
    }

    public ProjectRewardCategoryDTO getCategory() {
        return category;
    }

    public void setCategory(ProjectRewardCategoryDTO category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProjectBasicInfoDTO{" +
                "projectRegistInfoNo=" + projectRegistInfoNo +
                ", category=" + category +
                '}';
    }
}
