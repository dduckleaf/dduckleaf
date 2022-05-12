package com.greedy.dduckleaf.settlement.dto;

public class ProjectDTO {

    private int projectNo;                              //프로젝트번호
    private String projectName;                         //프로젝트명
    private int progressStatus;                         //진행상태
    private String projectStatus;                       //승인여부
    private int achievementRate;                        //달성률
    private int fundTargetAmount;                       //목표펀딩금액
    private FarmerInfoDTO farmer;                       //파머정보
    private String openDate;                            //오픈일
    private String endDate;                             //종료일
    private String examineStatus;                       //심사상태
    private String projectExamineStatus;                //심사결과
    private int maxTargetAmount;                        //목표최대금액

    public ProjectDTO() {}

    public ProjectDTO(int projectNo, String projectName, int progressStatus, String projectStatus, int achievementRate,
                      int fundTargetAmount, FarmerInfoDTO farmer, String openDate, String endDate, String examineStatus,
                      String projectExamineStatus, int maxTargetAmount) {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.progressStatus = progressStatus;
        this.projectStatus = projectStatus;
        this.achievementRate = achievementRate;
        this.fundTargetAmount = fundTargetAmount;
        this.farmer = farmer;
        this.openDate = openDate;
        this.endDate = endDate;
        this.examineStatus = examineStatus;
        this.projectExamineStatus = projectExamineStatus;
        this.maxTargetAmount = maxTargetAmount;
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

    public int getFundTargetAmount() {
        return fundTargetAmount;
    }

    public void setFundTargetAmount(int fundTargetAmount) {
        this.fundTargetAmount = fundTargetAmount;
    }

    public FarmerInfoDTO getFarmer() {
        return farmer;
    }

    public void setFarmer(FarmerInfoDTO farmer) {
        this.farmer = farmer;
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

    public int getMaxTargetAmount() {
        return maxTargetAmount;
    }

    public void setMaxTargetAmount(int maxTargetAmount) {
        this.maxTargetAmount = maxTargetAmount;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", progressStatus='" + progressStatus + '\'' +
                ", projectStatus='" + projectStatus + '\'' +
                ", achievementRate=" + achievementRate +
                ", fundTargetAmount=" + fundTargetAmount +
                ", farmer=" + farmer +
                ", openDate='" + openDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", examineStatus='" + examineStatus + '\'' +
                ", projectExamineStatus='" + projectExamineStatus + '\'' +
                ", maxTargetAmount=" + maxTargetAmount +
                '}';
    }
}
