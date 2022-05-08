package com.greedy.dduckleaf.project.entity;

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
@Entity(name = "FollowingProjectForProject")
@Table(name = "TBL_FOLLOWING_PROJECT")
public class FollowingProject {

    @Id
    @Column(name = "FOLLOWING_PROJECT_NO")
    private int followingProjectNo;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "MEMBER_NO")
    private int memberNo;
}
