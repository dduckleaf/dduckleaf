package com.greedy.dduckleaf.followingproject.dto;

public class FollowingProjectDTO {

    private int followingProjectNo;
    private int memberNo;
    private ProjectDTO project;

    public FollowingProjectDTO() {
    }

    public FollowingProjectDTO(int followingProjectNo, int memberNo, ProjectDTO project) {
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

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "FollowingProjectDTO{" +
                "followingProjectNo=" + followingProjectNo +
                ", memberNo=" + memberNo +
                ", project=" + project +
                '}';
    }
}
