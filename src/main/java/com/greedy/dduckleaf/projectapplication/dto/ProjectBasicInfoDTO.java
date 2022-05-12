package com.greedy.dduckleaf.projectapplication.dto;

public class ProjectBasicInfoDTO {          //프로젝트 기본정보

    private int projectBasicInfoNo;
    private int projectNo;
    private ProjectRewardCategoryDTO projectRewardCategory;
    private String projectName;
    private String projectEndDate;
    private String projectInfo;             //프로젝트 요약
    private int projectTargetFund;
    private String projectPromotionAgreementStatus;
    private String promotionAgreementDate;
    private String projectOpenDate;
    private int projectMaxTarget;

    public ProjectBasicInfoDTO() {
    }

    public ProjectBasicInfoDTO(int projectBasicInfoNo, int projectNo, ProjectRewardCategoryDTO projectRewardCategory, String projectName, String projectEndDate, String projectInfo, int projectTargetFund, String projectPromotionAgreementStatus, String promotionAgreementDate, String projectOpenDate, int projectMaxTarget) {
        this.projectBasicInfoNo = projectBasicInfoNo;
        this.projectNo = projectNo;
        this.projectRewardCategory = projectRewardCategory;
        this.projectName = projectName;
        this.projectEndDate = projectEndDate;
        this.projectInfo = projectInfo;
        this.projectTargetFund = projectTargetFund;
        this.projectPromotionAgreementStatus = projectPromotionAgreementStatus;
        this.promotionAgreementDate = promotionAgreementDate;
        this.projectOpenDate = projectOpenDate;
        this.projectMaxTarget = projectMaxTarget;
    }

    public int getProjectBasicInfoNo() {
        return projectBasicInfoNo;
    }

    public void setProjectBasicInfoNo(int projectBasicInfoNo) {
        this.projectBasicInfoNo = projectBasicInfoNo;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public ProjectRewardCategoryDTO getProjectRewardCategory() {
        return projectRewardCategory;
    }

    public void setProjectRewardCategory(ProjectRewardCategoryDTO projectRewardCategory) {
        this.projectRewardCategory = projectRewardCategory;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(String projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public String getProjectInfo() {
        return projectInfo;
    }

    public void setProjectInfo(String projectInfo) {
        this.projectInfo = projectInfo;
    }

    public int getProjectTargetFund() {
        return projectTargetFund;
    }

    public void setProjectTargetFund(int projectTargetFund) {
        this.projectTargetFund = projectTargetFund;
    }

    public String getProjectPromotionAgreementStatus() {
        return projectPromotionAgreementStatus;
    }

    public void setProjectPromotionAgreementStatus(String projectPromotionAgreementStatus) {
        this.projectPromotionAgreementStatus = projectPromotionAgreementStatus;
    }

    public String getPromotionAgreementDate() {
        return promotionAgreementDate;
    }

    public void setPromotionAgreementDate(String promotionAgreementDate) {
        this.promotionAgreementDate = promotionAgreementDate;
    }

    public String getProjectOpenDate() {
        return projectOpenDate;
    }

    public void setProjectOpenDate(String projectOpenDate) {
        this.projectOpenDate = projectOpenDate;
    }

    public int getProjectMaxTarget() {
        return projectMaxTarget;
    }

    public void setProjectMaxTarget(int projectMaxTarget) {
        this.projectMaxTarget = projectMaxTarget;
    }

    @Override
    public String toString() {
        return "ProjectBasicInfoDTO{" +
                "projectBasicInfoNo=" + projectBasicInfoNo +
                ", projectNo=" + projectNo +
                ", projectRewardCategory=" + projectRewardCategory +
                ", projectName='" + projectName + '\'' +
                ", projectEndDate='" + projectEndDate + '\'' +
                ", projectInfo='" + projectInfo + '\'' +
                ", projectTargetFund=" + projectTargetFund +
                ", projectPromotionAgreementStatus='" + projectPromotionAgreementStatus + '\'' +
                ", promotionAgreementDate='" + promotionAgreementDate + '\'' +
                ", projectOpenDate='" + projectOpenDate + '\'' +
                ", projectMaxTarget=" + projectMaxTarget +
                '}';
    }
}
