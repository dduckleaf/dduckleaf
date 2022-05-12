package com.greedy.dduckleaf.shippingmanagement.dto;

public class ProjectDTO {

    private int projectNo;          //프로젝트 번호
    private String projectName;     //프로젝트 이름
    private int fundTargetAmount;   //목표 금액
    private String openDate;        //시작일
    private String endDate;         //종료일
    private String projectStatus;   //취소 여부
    private double achievementRate; //달성률
    private ExamineProjectStatusDTO examineStatus;      //심사 상태
    private String projectExamineStatus;                //심사 결과
    private ProjectProgressStatusDTO progressStatus;    //진행 상태
    private int maxTargetAmount;    //목표 최대 금액
    private MemberDTO farmer;       //회원 정보
    private RewardShippingDTO rewardShippingList;       //리워드 발송 정보

    public ProjectDTO() {}

    public ProjectDTO(int projectNo, String projectName, int fundTargetAmount, String openDate, String endDate, String projectStatus, double achievementRate, ExamineProjectStatusDTO examineStatus, String projectExamineStatus, ProjectProgressStatusDTO progressStatus, int maxTargetAmount, MemberDTO farmer, RewardShippingDTO rewardShippingList) {
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
        this.rewardShippingList = rewardShippingList;
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

    public ExamineProjectStatusDTO getExamineStatus() {
        return examineStatus;
    }

    public void setExamineStatus(ExamineProjectStatusDTO examineStatus) {
        this.examineStatus = examineStatus;
    }

    public String getProjectExamineStatus() {
        return projectExamineStatus;
    }

    public void setProjectExamineStatus(String projectExamineStatus) {
        this.projectExamineStatus = projectExamineStatus;
    }

    public ProjectProgressStatusDTO getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(ProjectProgressStatusDTO progressStatus) {
        this.progressStatus = progressStatus;
    }

    public int getMaxTargetAmount() {
        return maxTargetAmount;
    }

    public void setMaxTargetAmount(int maxTargetAmount) {
        this.maxTargetAmount = maxTargetAmount;
    }

    public MemberDTO getFarmer() {
        return farmer;
    }

    public void setFarmer(MemberDTO farmer) {
        this.farmer = farmer;
    }

    public RewardShippingDTO getRewardShippingList() {
        return rewardShippingList;
    }

    public void setRewardShippingList(RewardShippingDTO rewardShippingList) {
        this.rewardShippingList = rewardShippingList;
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
                ", examineStatus=" + examineStatus +
                ", projectExamineStatus='" + projectExamineStatus + '\'' +
                ", progressStatus=" + progressStatus +
                ", maxTargetAmount=" + maxTargetAmount +
                ", farmer=" + farmer +
                ", rewardShippingList=" + rewardShippingList +
                '}';
    }
}
