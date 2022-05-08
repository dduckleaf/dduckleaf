package com.greedy.dduckleaf.followingproject.entity;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "FollowingProject")
@Table(name = "TBL_FOLLOWING_PROJECT")
public class FollowingProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOLLOWING_PROJECT_NO")
    private int followingProjectNo;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "PROJECT_NO")
    private int projectNo;
}
