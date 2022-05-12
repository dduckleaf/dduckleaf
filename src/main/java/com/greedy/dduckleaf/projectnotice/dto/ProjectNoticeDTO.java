package com.greedy.dduckleaf.projectnotice.dto;

import java.sql.Date;

public class ProjectNoticeDTO {

    private int projectNoticeNo;
    private String projectNoticeContent;
    private int projectNo;
    private java.sql.Date registDate;
    private String projectNoticeStatus;
    private String projectNoticeTitle;
    private int projectNoticeCount;
    private int farmerNo;

    public ProjectNoticeDTO() {
    }

    public ProjectNoticeDTO(int projectNoticeNo, String projectNoticeContent, int projectNo, Date registDate, String projectNoticeStatus, String projectNoticeTitle, int projectNoticeCount, int farmerNo) {
        this.projectNoticeNo = projectNoticeNo;
        this.projectNoticeContent = projectNoticeContent;
        this.projectNo = projectNo;
        this.registDate = registDate;
        this.projectNoticeStatus = projectNoticeStatus;
        this.projectNoticeTitle = projectNoticeTitle;
        this.projectNoticeCount = projectNoticeCount;
        this.farmerNo = farmerNo;
    }

    public int getProjectNoticeNo() {
        return projectNoticeNo;
    }

    public void setProjectNoticeNo(int projectNoticeNo) {
        this.projectNoticeNo = projectNoticeNo;
    }

    public String getProjectNoticeContent() {
        return projectNoticeContent;
    }

    public void setProjectNoticeContent(String projectNoticeContent) {
        this.projectNoticeContent = projectNoticeContent;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public String getProjectNoticeStatus() {
        return projectNoticeStatus;
    }

    public void setProjectNoticeStatus(String projectNoticeStatus) {
        this.projectNoticeStatus = projectNoticeStatus;
    }

    public String getProjectNoticeTitle() {
        return projectNoticeTitle;
    }

    public void setProjectNoticeTitle(String projectNoticeTitle) {
        this.projectNoticeTitle = projectNoticeTitle;
    }

    public int getProjectNoticeCount() {
        return projectNoticeCount;
    }

    public void setProjectNoticeCount(int projectNoticeCount) {
        this.projectNoticeCount = projectNoticeCount;
    }

    public int getFarmerNo() {
        return farmerNo;
    }

    public void setFarmerNo(int farmerNo) {
        this.farmerNo = farmerNo;
    }

    @Override
    public String toString() {
        return "ProjectNoticeDTO{" +
                "projectNoticeNo=" + projectNoticeNo +
                ", projectNoticeContent='" + projectNoticeContent + '\'' +
                ", projectNo=" + projectNo +
                ", registDate=" + registDate +
                ", projectNoticeStatus='" + projectNoticeStatus + '\'' +
                ", projectNoticeTitle='" + projectNoticeTitle + '\'' +
                ", projectNoticeCount=" + projectNoticeCount +
                ", farmerNo=" + farmerNo +
                '}';
    }
}
