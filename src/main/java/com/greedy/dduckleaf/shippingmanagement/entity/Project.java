package com.greedy.dduckleaf.shippingmanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "ProjectForShipping")
@Table(name = "TBL_PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_NO")
    private int projectNo;          //프로젝트 번호

    @Column(name = "PROJECT_NAME")
    private String projectName;     //프로젝트 이름

    @Column(name = "FUND_TARGET_AMOUNT")
    private int fundTargetAmount;   //목표 금액

    @Column(name = "OPEN_DATE")
    private String openDate;        //시작일

    @Column(name = "END_DATE")
    private String endDate;         //종료일

    @Column(name = "PROJECT_STATUS")
    private String projectStatus;   //취소 여부

    @Column(name = "ACHIEVEMENT_RATE")
    private double achievementRate; //달성률

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "EXAMINE_STATUS")
    private ExamineProjectStatus examineStatus;     //심사 상태

    @Column(name = "PROJECT_EXAMINE_STATUS")
    private String projectExamineStatus;            //심사 결과

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PROGRESS_STATUS")
    private ProjectProgressStatus progressStatus;   //진행 상태

    @Column(name = "MAX_TARGET_AMOUNT")
    private int maxTargetAmount;                    //목표 최대 금액

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FARMER_NO")
    private Member farmer;          //회원 번호

    @OneToMany(mappedBy = "project")
    private List<RewardShipping> rewardShippingList;    //리워드 발송 정보 1:N 매핑

    public Project() {}

    public Project(int projectNo, String projectName, int fundTargetAmount, String openDate, String endDate, String projectStatus, double achievementRate, ExamineProjectStatus examineStatus, String projectExamineStatus, ProjectProgressStatus progressStatus, int maxTargetAmount, Member farmer, List<RewardShipping> rewardShippingList) {
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

    public ExamineProjectStatus getExamineStatus() {
        return examineStatus;
    }

    public void setExamineStatus(ExamineProjectStatus examineStatus) {
        this.examineStatus = examineStatus;
    }

    public String getProjectExamineStatus() {
        return projectExamineStatus;
    }

    public void setProjectExamineStatus(String projectExamineStatus) {
        this.projectExamineStatus = projectExamineStatus;
    }

    public ProjectProgressStatus getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(ProjectProgressStatus progressStatus) {
        this.progressStatus = progressStatus;
    }

    public int getMaxTargetAmount() {
        return maxTargetAmount;
    }

    public void setMaxTargetAmount(int maxTargetAmount) {
        this.maxTargetAmount = maxTargetAmount;
    }

    public Member getFarmer() {
        return farmer;
    }

    public void setFarmer(Member farmer) {
        this.farmer = farmer;
    }

    public List<RewardShipping> getRewardShippingList() {
        return rewardShippingList;
    }

    public void setRewardShippingList(List<RewardShipping> rewardShippingList) {
        this.rewardShippingList = rewardShippingList;
    }

    @Override
    public String toString() {
        return "Project{" +
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
                '}';
    }
}
