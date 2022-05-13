package com.greedy.dduckleaf.projectapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "ProjectForProjectApplication")
@Table(name = "TBL_PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "PROJECT_NAME")
    @ColumnDefault(value = "'프로젝트 명'")
    private String projectName;

    @Column(name = "FUND_TARGET_AMOUNT")
    @ColumnDefault(value = "0")
    private int fundTargetAmount;

    @Column(name = "OPEN_DATE")
    @ColumnDefault("")
    private String openDate;

    @Column(name = "END_DATE")
    @ColumnDefault("NOW()")
    private String endDate;

    @Column(name = "PROJECT_STATUS")
    @ColumnDefault(value = "'N'")
    private String projectStatus;

    @Column(name = "ACHIEVEMENT_RATE")
    @ColumnDefault(value = "0")
    private double achievementRate;

    @Column(name = "EXAMINE_STATUS")
    @ColumnDefault(value = "'1'")
    private String examineStatus;               //심사상태

    @Column(name = "PROJECT_EXAMINE_STATUS")
    private String projectExamineStatus;        //심사결과

    @Column(name = "PROGRESS_STATUS")
    @ColumnDefault(value = "1")
    private int progressStatus;

    @Column(name = "MAX_TARGET_AMOUNT")
    @ColumnDefault(value = "0")
    private int maxTargetAmount;

    @ManyToOne
    @JoinColumn(name = "FARMER_NO")
    private FarmerInfo farmer;

    public Project() {
    }

    public Project(int projectNo, String projectName, int fundTargetAmount, String openDate, String endDate, String projectStatus, double achievementRate, String examineStatus, String projectExamineStatus, int progressStatus, int maxTargetAmount, FarmerInfo farmer) {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.fundTargetAmount = fundTargetAmount;
        this.openDate = openDate;
        this.endDate = endDate;
        this.projectStatus = projectStatus;
        this.achievementRate = achievementRate;
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

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public double getAchievementRate() {
        return achievementRate;
    }

    public void setAchievementRate(double achievementRate) {
        this.achievementRate = achievementRate;
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

    public FarmerInfo getFarmer() {
        return farmer;
    }

    public void setFarmer(FarmerInfo farmer) {
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
                ", achievementRate=" + achievementRate +
                ", examineStatus='" + examineStatus + '\'' +
                ", projectExamineStatus='" + projectExamineStatus + '\'' +
                ", progressStatus=" + progressStatus +
                ", maxTargetAmount=" + maxTargetAmount +
                ", farmer=" + farmer +
                '}';
    }

    @PrePersist
    public void prePersist() {

        this.projectName = this.projectName  == null ? "프로젝트 명" : this.projectName ;
        this.openDate = this.openDate  == null ? java.sql.Date.valueOf(LocalDate.now()).toString() : this.openDate ;
        this.endDate = this.endDate  == null ? java.sql.Date.valueOf(LocalDate.now().plusMonths(1)).toString() : this.endDate ;
        this.examineStatus = this.examineStatus  == null ? "1" : this.examineStatus ;
        this.projectStatus = this.projectStatus  == null ? "Y" : this.projectStatus ;

    }
}
