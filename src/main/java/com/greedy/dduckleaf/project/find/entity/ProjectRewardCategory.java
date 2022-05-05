package com.greedy.dduckleaf.project.find.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "ProjectRewardCategoryForProjectList")
@Table(name = "TBL_PROJECT_REWARD_CATEGORY")
public class ProjectRewardCategory {

    @Id
    @Column(name = "PROJECT_CATEGORY_NO")
    private int projectCategoryNo;

    @Column(name = "PROJECT_CATEGORY_NAME")
    private String projectCategoryName;
}
