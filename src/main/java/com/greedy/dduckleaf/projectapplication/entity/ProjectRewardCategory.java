package com.greedy.dduckleaf.projectapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "projectRewardCategory")
    private List<ProjectBasicInfo> projectBasicInfoList;

    @Override
    public String toString() {
        return "ProjectRewardCategory{" +
                "projectCategoryNo=" + projectCategoryNo +
                ", projectCategoryName='" + projectCategoryName + '\'' +
                '}';
    }
}
