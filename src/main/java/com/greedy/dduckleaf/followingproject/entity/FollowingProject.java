package com.greedy.dduckleaf.followingproject.entity;

import javax.persistence.*;

@Entity(name = "FollowingProject")
@Table(name = "TBL_FOLLOWING_PROJECT")
public class FollowingProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOLLOWING_PROJECT_NO")
    private int followingProjectNo;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PROJECT_NO")
    private Project project;

    public FollowingProject() {
    }

    public FollowingProject(int followingProjectNo, int memberNo, Project project) {
        this.followingProjectNo = followingProjectNo;
        this.memberNo = memberNo;
        this.project = project;
    }

    public int getFollowingProjectNo() {
        return followingProjectNo;
    }

    public void setFollowingProjectNo(int followingProjectNo) {
        this.followingProjectNo = followingProjectNo;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "FollowingProject{" +
                "followingProjectNo=" + followingProjectNo +
                ", memberNo=" + memberNo +
                ", project=" + project +
                '}';
    }
}
