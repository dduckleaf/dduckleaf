package com.greedy.dduckleaf.myfunding.dto;

public class ProjectDTO {

    private int projectNo;
    private int progressStatus;

    public ProjectDTO() {
    }

    public ProjectDTO(int projectNo, int progressStatus) {
        this.projectNo = projectNo;
        this.progressStatus = progressStatus;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public int getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(int progressStatus) {
        this.progressStatus = progressStatus;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectNo=" + projectNo +
                ", progressStatus=" + progressStatus +
                '}';
    }
}
