package com.greedy.dduckleaf.funding.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "ProjectForFunding")
@Table(name = "TBL_PROJECT")
public class Project {

    @Id
    @Column(name = "PROJECT_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectNo;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @Column(name = "FUND_TARGET_AMOUNT")
    private int fundTargetAmount;

    @Column(name = "OPEN_DATE")
    private String openDate;

    @Column(name = "END_DATE")
    private String endDate;

    @Column(name = "PROJECT_STATUS")
    private String projectStatus;

    @Column(name = "ACHIEVEMENT_RATE")
    private double achievementRate;

    @Column(name = "EXAMINE_STATUS")
    private String examineStatus;

    @Column(name = "PROJECT_EXAMINE_STATUS")
    private String projectExamineStatus;

    @Column(name = "PROGRESS_STATUS")
    private String progressStatus;

    @Column(name = "MAX_TARGET_AMOUNT")
    private int maxTargetAmount;

    @OneToOne
    @JoinColumn(name = "PROJECT_NO")
    private RewardInfo rewardInfo;

    @OneToOne
    @JoinColumn(name = "PROJECT_NO")
    private ProjectShippingFeeForProject projectShippingFee;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_NO")
    private ProjectShippingInfo projectShippingInfo;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_NO")
    private List<ProjectBasicInfo> basicInfo;

    @ManyToOne
    @JoinColumn(name = "FARMER_NO")
    private Member farmer;

    @OneToMany(mappedBy = "project")
    private List<Funding> fundingList;

    public Project() {
    }

    public Project(int projectNo, String projectName, int fundTargetAmount, String openDate, String endDate, String projectStatus, double achievementRate, String examineStatus, String projectExamineStatus, String progressStatus, int maxTargetAmount, RewardInfo rewardInfo, ProjectShippingFeeForProject projectShippingFee, ProjectShippingInfo projectShippingInfo, List<ProjectBasicInfo> basicInfo, Member farmer, List<Funding> fundingList) {
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
        this.projectShippingInfo = projectShippingInfo;
        this.basicInfo = basicInfo;
        this.farmer = farmer;
        this.fundingList = fundingList;
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

    public RewardInfo getRewardInfo() {
        return rewardInfo;
    }

    public void setRewardInfo(RewardInfo rewardInfo) {
        this.rewardInfo = rewardInfo;
    }

    public ProjectShippingFeeForProject getProjectShippingFee() {
        return projectShippingFee;
    }

    public void setProjectShippingFee(ProjectShippingFeeForProject projectShippingFee) {
        this.projectShippingFee = projectShippingFee;
    }

    public ProjectShippingInfo getProjectShippingInfo() {
        return projectShippingInfo;
    }

    public void setProjectShippingInfo(ProjectShippingInfo projectShippingInfo) {
        this.projectShippingInfo = projectShippingInfo;
    }

    public List<ProjectBasicInfo> getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(List<ProjectBasicInfo> basicInfo) {
        this.basicInfo = basicInfo;
    }

    public Member getFarmer() {
        return farmer;
    }

    public void setFarmer(Member farmer) {
        this.farmer = farmer;
    }

    public List<Funding> getFundingList() {
        return fundingList;
    }

    public void setFundingList(List<Funding> fundingList) {
        this.fundingList = fundingList;
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
                ", examineStatus='" + examineStatus + '\'' +
                ", projectExamineStatus='" + projectExamineStatus + '\'' +
                ", progressStatus='" + progressStatus + '\'' +
                ", maxTargetAmount=" + maxTargetAmount +
                ", rewardInfo=" + rewardInfo +
                ", projectShippingFee=" + projectShippingFee +
                ", projectShippingInfo=" + projectShippingInfo +
                ", farmer=" + farmer +
                '}';
    }
}
