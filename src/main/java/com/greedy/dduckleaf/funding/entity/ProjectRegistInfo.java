package com.greedy.dduckleaf.funding.entity;

import javax.persistence.*;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "ProjectRegistInfoForFunding")
@Table(name = "TBL_PROJECT_REGIST_INFO")
public class ProjectRegistInfo {

    @Id
    @Column(name = "PROJECT_REGIST_INFO_NO")
    private int projectRegistInfoNo;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "PROJECT_REGIST_INFO_CATEGORY")
    private String projectRegistInfoCategory;

    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_CATEGORY_NO")
    private ProjectRewardCategory category;
}
