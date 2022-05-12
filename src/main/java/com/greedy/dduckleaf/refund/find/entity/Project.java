package com.greedy.dduckleaf.refund.find.entity;

import javax.persistence.*;

@Entity(name = "ProjectForRefundingFind")
@Table(name = "TBL_PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROGRESS_STATUS")
    private ProjectProgressStatus progressStatus;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_NO")
    private RewardInfo rewardInfo;

    @Column(name = "FARMER_NO")
    private int farmerNo;

    public Project() {
    }

    public Project(int projectNo, String projectName, ProjectProgressStatus progressStatus, RewardInfo rewardInfo, int farmerNo) {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.progressStatus = progressStatus;
        this.rewardInfo = rewardInfo;
        this.farmerNo = farmerNo;
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

    public ProjectProgressStatus getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(ProjectProgressStatus progressStatus) {
        this.progressStatus = progressStatus;
    }

    public RewardInfo getRewardInfo() {
        return rewardInfo;
    }

    public void setRewardInfo(RewardInfo rewardInfo) {
        this.rewardInfo = rewardInfo;
    }

    public int getFarmerNo() {
        return farmerNo;
    }

    public void setFarmerNo(int farmerNo) {
        this.farmerNo = farmerNo;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", progressStatus=" + progressStatus +
                ", rewardInfo=" + rewardInfo +
                ", farmerNo=" + farmerNo +
                '}';
    }
}