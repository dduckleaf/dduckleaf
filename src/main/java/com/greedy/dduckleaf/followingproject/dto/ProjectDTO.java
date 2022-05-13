package com.greedy.dduckleaf.followingproject.dto;

import java.sql.Date;

public class ProjectDTO {

    private int projectNo;
    private String projectName;
    private java.sql.Date openDate;
    private java.sql.Date endDate;
    private String projectStatus;
    private int achievementRate;
    private ProjectProgressStatusDTO projectProgressStatus;
    private FarmerDTO farmer;
    private long deadLine;
    private String attachmentSavedName;

    public ProjectDTO() {
    }

    public ProjectDTO(int projectNo, String projectName, Date openDate, Date endDate, String projectStatus, int achievementRate, ProjectProgressStatusDTO projectProgressStatus, FarmerDTO farmer, long deadLine, String attachmentSavedName) {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.openDate = openDate;
        this.endDate = endDate;
        this.projectStatus = projectStatus;
        this.achievementRate = achievementRate;
        this.projectProgressStatus = projectProgressStatus;
        this.farmer = farmer;
        this.deadLine = deadLine;
        this.attachmentSavedName = attachmentSavedName;
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

    public int getAchievementRate() {
        return achievementRate;
    }

    public void setAchievementRate(int achievementRate) {
        this.achievementRate = achievementRate;
    }

    public ProjectProgressStatusDTO getProjectProgressStatus() {
        return projectProgressStatus;
    }

    public void setProjectProgressStatus(ProjectProgressStatusDTO projectProgressStatus) {
        this.projectProgressStatus = projectProgressStatus;
    }

    public FarmerDTO getFarmer() {
        return farmer;
    }

    public void setFarmer(FarmerDTO farmer) {
        this.farmer = farmer;
    }

    public long getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(long deadLine) {
        this.deadLine = deadLine;
    }

    public String getAttachmentSavedName() {
        return attachmentSavedName;
    }

    public void setAttachmentSavedName(String attachmentSavedName) {
        this.attachmentSavedName = attachmentSavedName;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", openDate=" + openDate +
                ", endDate=" + endDate +
                ", projectStatus='" + projectStatus + '\'' +
                ", achievementRate=" + achievementRate +
                ", projectProgressStatus=" + projectProgressStatus +
                ", farmer=" + farmer +
                ", deadLine=" + deadLine +
                ", attachmentSavedName='" + attachmentSavedName + '\'' +
                '}';
    }
}
