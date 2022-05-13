package com.greedy.dduckleaf.projectreport.find.dto;

import com.greedy.dduckleaf.projectreport.find.entity.FarmerInfo;

import javax.persistence.*;

public class ProjectDTO {

    private int projectNo;
    private String projectName;
    private int progressStatus;
    private String openDate;
    private String endDate;
    private double achievementRate;
    private FarmerInfo farmer;

    public ProjectDTO() {}

    public ProjectDTO(int projectNo, String projectName, int progressStatus, String openDate, String endDate,
                      double achievementRate, FarmerInfo farmer) {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.progressStatus = progressStatus;
        this.openDate = openDate;
        this.endDate = endDate;
        this.achievementRate = achievementRate;
        this.farmer = farmer;
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

    public int getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(int progressStatus) {
        this.progressStatus = progressStatus;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getAchievementRate() {
        return achievementRate;
    }

    public void setAchievementRate(double achievementRate) {
        this.achievementRate = achievementRate;
    }

    public FarmerInfo getFarmer() {
        return farmer;
    }

    public void setFarmer(FarmerInfo farmer) {
        this.farmer = farmer;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", progressStatus=" + progressStatus +
                ", openDate='" + openDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", achievementRate=" + achievementRate +
                ", farmer=" + farmer +
                '}';
    }
}
