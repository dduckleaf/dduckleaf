package com.greedy.dduckleaf.refund.find.dto;

public class ProjectProgressStatusDTO {

    private int progressNo;
    private String progressName;

    public ProjectProgressStatusDTO() {
    }

    public ProjectProgressStatusDTO(int progressNo, String progressName) {
        this.progressNo = progressNo;
        this.progressName = progressName;
    }

    public int getProgressNo() {
        return progressNo;
    }

    public void setProgressNo(int progressNo) {
        this.progressNo = progressNo;
    }

    public String getProgressName() {
        return progressName;
    }

    public void setProgressName(String progressName) {
        this.progressName = progressName;
    }

    @Override
    public String toString() {
        return "ProjectProgressStatusDTO{" +
                "progressNo=" + progressNo +
                ", progressName='" + progressName + '\'' +
                '}';
    }
}