package com.greedy.dduckleaf.followingproject.dto;

public class ProjectProgressStatusDTO {

    private int projectProgressStatusNo;
    private String projectProgressStatusName;

    public ProjectProgressStatusDTO() {
    }

    public ProjectProgressStatusDTO(int projectProgressStatusNo, String projectProgressStatusName) {
        this.projectProgressStatusNo = projectProgressStatusNo;
        this.projectProgressStatusName = projectProgressStatusName;
    }

    public int getProjectProgressStatusNo() {
        return projectProgressStatusNo;
    }

    public void setProjectProgressStatusNo(int projectProgressStatusNo) {
        this.projectProgressStatusNo = projectProgressStatusNo;
    }

    public String getProjectProgressStatusName() {
        return projectProgressStatusName;
    }

    public void setProjectProgressStatusName(String projectProgressStatusName) {
        this.projectProgressStatusName = projectProgressStatusName;
    }

    @Override
    public String toString() {
        return "ProjectProgressStatusDTO{" +
                "projectProgressStatusNo=" + projectProgressStatusNo +
                ", projectProgressStatusName='" + projectProgressStatusName + '\'' +
                '}';
    }
}
