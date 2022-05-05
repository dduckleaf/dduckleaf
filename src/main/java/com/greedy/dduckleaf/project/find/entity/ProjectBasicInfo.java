package com.greedy.dduckleaf.project.find.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "ProjectBasicInfoForProjectList")
@Table(name = "TBL_PROJECT_BASIC_INFO")
public class ProjectBasicInfo {

    @Column(name = "PROJECT_BASIC_INFO_NO")
    private int projectRegistInfoNo;

    @Id
    @Column(name = "PROJECT_NO")
    private int projectNo;

    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_CATEGORY_NO")
    private ProjectRewardCategory category;
}
