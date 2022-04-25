package com.greedy.dduckleaf.projectapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "ProjectRewardCategory")
@Table(name = "TBL_PROJECT_REWARD_CATEGORY")
public class ProjectRewardCategory {

    @Id
    @Column(name = "PROJECT_CATEGORY_NO")
    private int projectCategoryNo;

    @Column(name = "PROJECT_CATEGORY_NAME")
    private String projectCategoryName;

    @Override
    public String toString() {
        return "ProjectRewardCategory{" +
                "projectCategoryNo=" + projectCategoryNo +
                ", projectCategoryName='" + projectCategoryName + '\'' +
                '}';
    }
}
