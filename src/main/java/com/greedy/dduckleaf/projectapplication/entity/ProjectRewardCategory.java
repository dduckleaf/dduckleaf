package com.greedy.dduckleaf.projectapplication.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "ProjectRewardCategory")
@Table(name = "TBL_PROJECT_REWARD_CATEGORY")
public class ProjectRewardCategory {

    @Id
    @Column(name = "PROJECT_CATEGORY_NO")
    private int projectCategoryNo;

    @Column(name = "PROJECT_CATEGORY_NAME")
    private String projectCategoryName;

    @OneToMany(mappedBy = "projectRewardCategory")
    private List<ProjectBasicInfo> projectBasicInfoList;

    public ProjectRewardCategory() {
    }

    public ProjectRewardCategory(int projectCategoryNo, String projectCategoryName, List<ProjectBasicInfo> projectBasicInfoList) {
        this.projectCategoryNo = projectCategoryNo;
        this.projectCategoryName = projectCategoryName;
        this.projectBasicInfoList = projectBasicInfoList;
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

    public List<ProjectBasicInfo> getProjectBasicInfoList() {
        return projectBasicInfoList;
    }

    public void setProjectBasicInfoList(List<ProjectBasicInfo> projectBasicInfoList) {
        this.projectBasicInfoList = projectBasicInfoList;
    }

    @Override
    public String toString() {
        return "ProjectRewardCategory{" +
                "projectCategoryNo=" + projectCategoryNo +
                ", projectCategoryName='" + projectCategoryName + '\'' +
                '}';
    }

    @PrePersist
    public void prePersist() {

        this.projectCategoryName = this.projectCategoryName  == null ? "카테고리" : this.projectCategoryName ;

    }
}
