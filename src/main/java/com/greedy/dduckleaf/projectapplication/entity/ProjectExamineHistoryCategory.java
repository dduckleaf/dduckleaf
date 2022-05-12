package com.greedy.dduckleaf.projectapplication.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "ProjectExamineHistoryCategoryForProjectApplication")
@Table(name = "TBL_PROJECT_EXAMINE_HISTORY")
@DynamicInsert
public class ProjectExamineHistoryCategory {

    @Id
    @Column(name = "PROJECT_EXAMINE_HISTORY_CATEGORY_NO")
    private int projectExamineHistoryCategoryNo;

    @Column(name = "PROJECT_EXAMINE_HISTORY_CATEGORY_NAME")
    private String projectExamineHistoryCategoryName;

    public ProjectExamineHistoryCategory() {
    }

    public ProjectExamineHistoryCategory(int projectExamineHistoryCategoryNo, String projectExamineHistoryCategoryName) {
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
        return "ProjectExamineHistoryCategory{" +
                "projectExamineHistoryCategoryNo=" + projectExamineHistoryCategoryNo +
                ", projectExamineHistoryCategoryName='" + projectExamineHistoryCategoryName + '\'' +
                '}';
    }
}
