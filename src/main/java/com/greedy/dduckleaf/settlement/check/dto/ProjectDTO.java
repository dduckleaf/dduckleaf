package com.greedy.dduckleaf.settlement.check.dto;

public class ProjectDTO {

    private int projectNo;                  //프로젝트 번호
    private String projectName;             //프로젝트명
    private String openDate;                //오픈일
    private String endDate;                 //종료일
    private String achievementRate;         //달성률
    private String progressStatus;          //진행상태
    private FarmerInfoDTO farmer;              //파머번호

    public ProjectDTO() {}

    public ProjectDTO(int projectNo, String projectName, String openDate, String endDate, String achievementRate,
                      String progressStatus, FarmerInfoDTO farmer) {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.openDate = openDate;
        this.endDate = endDate;
        this.achievementRate = achievementRate;
        this.progressStatus = progressStatus;
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

    public String getAchievementRate() {
        return achievementRate;
    }

    public void setAchievementRate(String achievementRate) {
        this.achievementRate = achievementRate;
    }

    public String getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(String progressStatus) {
        this.progressStatus = progressStatus;
    }

    public FarmerInfoDTO getFarmer() {
        return farmer;
    }

    public void setFarmer(FarmerInfoDTO farmer) {
        this.farmer = farmer;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", openDate='" + openDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", achievementRate='" + achievementRate + '\'' +
                ", progressStatus='" + progressStatus + '\'' +
                ", farmer=" + farmer +
                '}';
    }
}
