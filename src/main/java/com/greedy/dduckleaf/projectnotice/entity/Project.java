package com.greedy.dduckleaf.projectnotice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity(name = "Project")
@Table(name = "TBL_PROJECT")
public class Project {

    @Id
    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @Column(name = "FUND_TARGET_AMOUNT")
    private int fundTargetAmount;

    @Column(name = "OPEN_DATE")
    private java.util.Date openDate;

    @Column(name = "END_DATE")
    private java.util.Date endDate;

    @Column(name = "PROJECT_STATUS")
    private String projectStatus;

    @Column(name = "ACHIEVEMENT_RATE")
    private double achivementStatus;

    @Column(name = "EXAMINE_STATUS")
    private String examineStatus;

    @Column(name = "PROJECT_EXAMINE_STAUTS")
    private String projectExamineStatus;

    @Column(name = "PROGRESS_STATUS")
    private int progressStatus;

    @Column(name = "MAX_TARGET_AMOUNT")
    private int maxTargetAmount;

    @Column(name = "")
    private int farmer;

    public Project() {}

    public Project(int projectNo, String projectName, int fundTargetAmount, Date openDate, Date endDate, String projectStatus, double achivementStatus, String examineStatus, String projectExamineStatus, int progressStatus, int maxTargetAmount, int farmer) {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.fundTargetAmount = fundTargetAmount;
        this.openDate = openDate;
        this.endDate = endDate;
        this.projectStatus = projectStatus;
        this.achivementStatus = achivementStatus;
        this.examineStatus = examineStatus;
        this.projectExamineStatus = projectExamineStatus;
        this.progressStatus = progressStatus;
        this.maxTargetAmount = maxTargetAmount;
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
        return "Project{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", fundTargetAmount=" + fundTargetAmount +
                ", openDate=" + openDate +
                ", endDate=" + endDate +
                ", projectStatus='" + projectStatus + '\'' +
                ", achivementStatus=" + achivementStatus +
                ", examineStatus='" + examineStatus + '\'' +
                ", projectExamineStatus='" + projectExamineStatus + '\'' +
                ", progressStatus=" + progressStatus +
                ", maxTargetAmount=" + maxTargetAmount +
                ", farmer=" + farmer +
                '}';
    }
}
