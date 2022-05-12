package com.greedy.dduckleaf.projectapplication.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "ProjectBasicInfoForProjectApplication")
@Table(name = "TBL_PROJECT_BASIC_INFO")
@DynamicInsert
public class ProjectBasicInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_BASIC_INFO_NO")
    private int projectBasicInfoNo;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PROJECT_CATEGORY_NO")
    private ProjectRewardCategory projectRewardCategory;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @Column(name = "PROJECT_END_DATE")
    private String projectEndDate;

    @Column(name = "PROJECT_INFO")
    private String projectInfo;             //프로젝트 요약

    @Column(name = "PROJECT_TARGET_FUND")
    private int projectTargetFund;

    @Column(name = "PROJECT_PROMOTION_AGREEMENT_STATUS")
    private String projectPromotionAgreementStatus;

    @Column(name = "PROMOTION_AGREEMENT_DATE")
    private String promotionAgreementDate;

    @Column(name = "PROJECT_OPEN_DATE")
    private String projectOpenDate;

    @Column(name = "PROJECT_MAX_TARGET")
    private int projectMaxTarget;

    public ProjectBasicInfo() {
    }

    public ProjectBasicInfo(int projectBasicInfoNo, int projectNo, ProjectRewardCategory projectRewardCategory, String projectName, String projectEndDate, String projectInfo, int projectTargetFund, String projectPromotionAgreementStatus, String promotionAgreementDate, String projectOpenDate, int projectMaxTarget) {
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

    public ProjectRewardCategory getProjectRewardCategory() {
        return projectRewardCategory;
    }

    public void setProjectRewardCategory(ProjectRewardCategory projectRewardCategory) {
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
        return "ProjectBasicInfo{" +
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

    @PrePersist
    public void prePersist() {

        this.projectName = this.projectName  == null ? "프로젝트 명" : this.projectName ;
        this.projectEndDate = this.projectEndDate  == null ? java.sql.Date.valueOf(LocalDate.now().plusMonths(1).plusDays(7)).toString() : this.projectEndDate ;
        this.projectInfo = this.projectInfo  == null ? "프로젝트에 대해 요약해주세요" : this.projectInfo ;
        this.promotionAgreementDate = this.promotionAgreementDate  == null ? java.sql.Date.valueOf(LocalDate.now()).toString() : this.promotionAgreementDate ;
        this.projectOpenDate = this.projectOpenDate  == null ? java.sql.Date.valueOf(LocalDate.now()).toString() : this.projectOpenDate ;

    }
}
