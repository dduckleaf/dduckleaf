package com.greedy.dduckleaf.project.find.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "ProjectRegistInfoForProjectList")
@Table(name = "TBL_PROJECT_REGIST_INFO")
public class ProjectRegistInfo {

    @Column(name = "PROJECT_REGIST_INFO_NO")
    private int projectRegistInfoNo;

    @Id
    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "PROJECT_REGIST_INFO_CATEGORY")
    private String projectRegistInfoCategory;

    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_CATEGORY_NO")
    private ProjectRewardCategory category;
}
