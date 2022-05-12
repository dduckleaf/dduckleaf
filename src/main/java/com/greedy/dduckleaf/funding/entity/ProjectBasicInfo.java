package com.greedy.dduckleaf.funding.entity;

import javax.persistence.*;


import lombok.*;

@Entity(name = "ProjectBasicInfoForFunding")
@Table(name = "TBL_PROJECT_BASIC_INFO")
public class ProjectBasicInfo {

    @Id
    @Column(name = "PROJECT_BASIC_INFO_NO")
    private int projectRegistInfoNo;

    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_CATEGORY_NO")
    private ProjectRewardCategory category;

    public ProjectBasicInfo() {
    }

    public ProjectBasicInfo(int projectRegistInfoNo, ProjectRewardCategory category) {
        this.projectRegistInfoNo = projectRegistInfoNo;
        this.category = category;
    }

    public int getProjectRegistInfoNo() {
        return projectRegistInfoNo;
    }

    public void setProjectRegistInfoNo(int projectRegistInfoNo) {
        this.projectRegistInfoNo = projectRegistInfoNo;
    }

    public ProjectRewardCategory getCategory() {
        return category;
    }

    public void setCategory(ProjectRewardCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProjectBasicInfo{" +
                "projectRegistInfoNo=" + projectRegistInfoNo +
                ", category=" + category +
                '}';
    }
}
