package com.greedy.dduckleaf.refund.find.dto;

public class ProjectDTO {

    private int projectNo;
    private String projectName;
    private RewardInfoDTO rewardInfo;
    private ProjectProgressStatusDTO progressStatus;
    private int farmerNo;

    public ProjectDTO() {
    }

    public ProjectDTO(int projectNo, String projectName, RewardInfoDTO rewardInfo, ProjectProgressStatusDTO progressStatus, int farmerNo) {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.rewardInfo = rewardInfo;
        this.progressStatus = progressStatus;
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

    public RewardInfoDTO getRewardInfo() {
        return rewardInfo;
    }

    public void setRewardInfo(RewardInfoDTO rewardInfo) {
        this.rewardInfo = rewardInfo;
    }

    public ProjectProgressStatusDTO getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(ProjectProgressStatusDTO progressStatus) {
        this.progressStatus = progressStatus;
    }

    public int getFarmerNo() {
        return farmerNo;
    }

    public void setFarmerNo(int farmerNo) {
        this.farmerNo = farmerNo;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", rewardInfo=" + rewardInfo +
                ", progressStatus=" + progressStatus +
                ", farmerNo=" + farmerNo +
                '}';
    }
}