package com.greedy.dduckleaf.funding.entity;

import javax.persistence.*;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "ProjectBasicInfoForFunding")
@Table(name = "TBL_PROJECT_BASIC_INFO")
public class ProjectBasicInfo {

    @Id
    @Column(name = "PROJECT_BASIC_INFO_NO")
    private int projectRegistInfoNo;


    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_CATEGORY_NO")
    private ProjectRewardCategory category;
}
