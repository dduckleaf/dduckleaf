package com.greedy.dduckleaf.funding.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "ProjectRewardCategoryForFunding")
@Table(name = "TBL_PROJECT_REWARD_CATEGORY")
public class ProjectRewardCategory {

    @Id
    @Column(name = "PROJECT_CATEGORY_NO")
    private int projectCategoryNo;

    @Column(name = "PROJECT_CATEGORY_NAME")
    private String projectCategoryName;

    public ProjectRewardCategory() {
    }

    public ProjectRewardCategory(int projectCategoryNo, String projectCategoryName) {
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
        return "ProjectRewardCategory{" +
                "projectCategoryNo=" + projectCategoryNo +
                ", projectCategoryName='" + projectCategoryName + '\'' +
                '}';
    }
}
