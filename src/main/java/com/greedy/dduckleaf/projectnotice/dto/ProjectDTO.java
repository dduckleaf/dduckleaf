package com.greedy.dduckleaf.projectnotice.dto;

import java.util.Date;

public class ProjectDTO {

    private String projectName;
    private int fundTargetAmount;
    private java.util.Date openDate;
    private java.util.Date endDate;
    private String projectStatus;
    private double achivementStatus;
    private int projectNo;
    private String examineStatus;
    private String projectExamineStatus;
    private int progressStatus;
    private int maxTargetAmount;
    private int farmer;

    public ProjectDTO() {}

    public ProjectDTO(String projectName, int fundTargetAmount, Date openDate, Date endDate, String projectStatus, double achivementStatus, int projectNo, String examineStatus, String projectExamineStatus, int progressStatus, int maxTargetAmount, int farmer) {
        this.projectName = projectName;
        this.fundTargetAmount = fundTargetAmount;
        this.openDate = openDate;
        this.endDate = endDate;
        this.projectStatus = projectStatus;
        this.achivementStatus = achivementStatus;
        this.projectNo = projectNo;
        this.examineStatus = examineStatus;
        this.projectExamineStatus = projectExamineStatus;
        this.progressStatus = progressStatus;
        this.maxTargetAmount = maxTargetAmount;
        this.farmer = farmer;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getFundTargetAmount() {
        return fundTargetAmount;
    }

    public void setFundTargetAmount(int fundTargetAmount) {
        this.fundTargetAmount = fundTargetAmount;
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

    public double getAchivementStatus() {
        return achivementStatus;
    }

    public void setAchivementStatus(double achivementStatus) {
        this.achivementStatus = achivementStatus;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getExamineStatus() {
        return examineStatus;
    }

    public void setExamineStatus(String examineStatus) {
        this.examineStatus = examineStatus;
    }

    public String getProjectExamineStatus() {
        return projectExamineStatus;
    }

    public void setProjectExamineStatus(String projectExamineStatus) {
        this.projectExamineStatus = projectExamineStatus;
    }

    public int getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(int progressStatus) {
        this.progressStatus = progressStatus;
    }

    public int getMaxTargetAmount() {
        return maxTargetAmount;
    }

    public void setMaxTargetAmount(int maxTargetAmount) {
        this.maxTargetAmount = maxTargetAmount;
    }

    public int getFarmer() {
        return farmer;
    }

    public void setFarmer(int farmer) {
        this.farmer = farmer;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectName='" + projectName + '\'' +
                ", fundTargetAmount=" + fundTargetAmount +
                ", openDate=" + openDate +
                ", endDate=" + endDate +
                ", projectStatus='" + projectStatus + '\'' +
                ", achivementStatus=" + achivementStatus +
                ", projectNo=" + projectNo +
                ", examineStatus='" + examineStatus + '\'' +
                ", projectExamineStatus='" + projectExamineStatus + '\'' +
                ", progressStatus=" + progressStatus +
                ", maxTargetAmount=" + maxTargetAmount +
                ", farmer=" + farmer +
                '}';
    }
}
