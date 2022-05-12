package com.greedy.dduckleaf.shippingmanagement.dto;

public class ProjectProgressStatusDTO {

    private int projectProgressStatusNo;        //진행 상태 코드
    private String projectProgressStatusName;   //진행 상태명

    public ProjectProgressStatusDTO() {}

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
