package com.greedy.dduckleaf.projectreport.find.entity;

import javax.persistence.*;

@Entity(name = "ProjectForProjectReport")
@Table(name = "TBL_PROJECT")
public class Project {

    @Id
    @Column(name = "PROJECT_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectNo;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @Column(name = "PROGRESS_STATUS")
    private int progressStatus;

    @Column(name = "OPEN_DATE")
    private String openDate;

    @Column(name = "END_DATE")
    private String endDate;

    @Column(name = "ACHIEVEMENT_RATE")
    private double achievementRate;

    @ManyToOne
    @JoinColumn(name = "FARMER_NO")
    private FarmerInfo farmerInfo;

    public Project() {}

    public Project(int projectNo, String projectName, int progressStatus, String openDate, String endDate,
                   double achievementRate, FarmerInfo farmerInfo) {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.progressStatus = progressStatus;
        this.openDate = openDate;
        this.endDate = endDate;
        this.achievementRate = achievementRate;
        this.farmerInfo = farmerInfo;
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

    public FarmerInfo getFarmerInfo() {
        return farmerInfo;
    }

    public void setFarmerInfo(FarmerInfo farmerInfo) {
        this.farmerInfo = farmerInfo;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", progressStatus=" + progressStatus +
                ", openDate='" + openDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", achievementRate=" + achievementRate +
                ", farmerInfo=" + farmerInfo +
                '}';
    }
}
