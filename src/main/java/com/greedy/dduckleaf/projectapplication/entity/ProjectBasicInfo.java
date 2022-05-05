package com.greedy.dduckleaf.projectapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "ProjectBasicInfoForProjectApplication")
@Table(name = "TBL_PROJECT_BASIC_INFO")
@DynamicInsert
public class ProjectBasicInfo {

    @Id
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
