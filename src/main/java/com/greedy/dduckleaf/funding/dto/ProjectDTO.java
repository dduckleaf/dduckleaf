package com.greedy.dduckleaf.funding.dto;

import java.util.List;

public class ProjectDTO {

    private int projectNo;
    private String projectName;
    private int fundTargetAmount;
    private String openDate;
    private String endDate;
    private String projectStatus;
    private double achievementRate;
    private String examineStatus;
    private String projectExamineStatus;
    private String progressStatus;
    private int maxTargetAmount;
    private RewardInfoDTO rewardInfo;
    private ProjectShippingFeeDTO projectShippingFee;
    private MemberDTO farmer;
    private List<ProjectBasicInfoDTO> basicInfo;

    public ProjectDTO() {
    }

    public ProjectDTO(int projectNo, String projectName, int fundTargetAmount, String openDate, String endDate, String projectStatus, double achievementRate, String examineStatus, String projectExamineStatus, String progressStatus, int maxTargetAmount, RewardInfoDTO rewardInfo, ProjectShippingFeeDTO projectShippingFee, MemberDTO farmer, List<ProjectBasicInfoDTO> basicInfo) {
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
        this.rewardInfo = rewardInfo;
        this.projectShippingFee = projectShippingFee;
        this.farmer = farmer;
        this.basicInfo = basicInfo;
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

    public String getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(String progressStatus) {
        this.progressStatus = progressStatus;
    }

    public int getMaxTargetAmount() {
        return maxTargetAmount;
    }

    public void setMaxTargetAmount(int maxTargetAmount) {
        this.maxTargetAmount = maxTargetAmount;
    }

    public RewardInfoDTO getRewardInfo() {
        return rewardInfo;
    }

    public void setRewardInfo(RewardInfoDTO rewardInfo) {
        this.rewardInfo = rewardInfo;
    }

    public ProjectShippingFeeDTO getProjectShippingFee() {
        return projectShippingFee;
    }

    public void setProjectShippingFee(ProjectShippingFeeDTO projectShippingFee) {
        this.projectShippingFee = projectShippingFee;
    }

    public MemberDTO getFarmer() {
        return farmer;
    }

    public void setFarmer(MemberDTO farmer) {
        this.farmer = farmer;
    }

    public List<ProjectBasicInfoDTO> getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(List<ProjectBasicInfoDTO> basicInfo) {
        this.basicInfo = basicInfo;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", fundTargetAmount=" + fundTargetAmount +
                ", openDate='" + openDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", projectStatus='" + projectStatus + '\'' +
                ", achievementRate=" + achievementRate +
                ", examineStatus='" + examineStatus + '\'' +
                ", projectExamineStatus='" + projectExamineStatus + '\'' +
                ", progressStatus='" + progressStatus + '\'' +
                ", maxTargetAmount=" + maxTargetAmount +
                ", rewardInfo=" + rewardInfo +
                ", projectShippingFee=" + projectShippingFee +
                ", farmer=" + farmer +
                ", basicInfo=" + basicInfo +
                '}';
    }
}
