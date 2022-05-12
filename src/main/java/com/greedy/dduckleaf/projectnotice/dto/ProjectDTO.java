package com.greedy.dduckleaf.projectnotice.dto;

import java.sql.Date;
import java.util.List;

public class ProjectDTO {

    private int projectNo;
    private String projectName;
    private java.sql.Date openDate;
    private java.sql.Date endDate;
    private String projectStatus;
    private int progressStatus;
    private int farmerNo;
    private List<ProjectNoticeDTO> projectNoticeList;

    public ProjectDTO() {
    }

    public ProjectDTO(int projectNo, String projectName, Date openDate, Date endDate, String projectStatus, int progressStatus, int farmerNo, List<ProjectNoticeDTO> projectNoticeList) {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.openDate = openDate;
        this.endDate = endDate;
        this.projectStatus = projectStatus;
        this.progressStatus = progressStatus;
        this.farmerNo = farmerNo;
        this.projectNoticeList = projectNoticeList;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public int getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(int progressStatus) {
        this.progressStatus = progressStatus;
    }

    public int getFarmerNo() {
        return farmerNo;
    }

    public void setFarmerNo(int farmerNo) {
        this.farmerNo = farmerNo;
    }

    public List<ProjectNoticeDTO> getProjectNoticeList() {
        return projectNoticeList;
    }

    public void setProjectNoticeList(List<ProjectNoticeDTO> projectNoticeList) {
        this.projectNoticeList = projectNoticeList;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", openDate=" + openDate +
                ", endDate=" + endDate +
                ", projectStatus='" + projectStatus + '\'' +
                ", progressStatus=" + progressStatus +
                ", farmerNo=" + farmerNo +
                ", projectNoticeList=" + projectNoticeList +
                '}';
    }
}
