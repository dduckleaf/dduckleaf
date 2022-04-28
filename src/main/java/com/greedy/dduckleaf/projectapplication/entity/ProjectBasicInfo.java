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
    @JoinColumn(name = "PROJECT_BASIC_CATEGORY_NO")
    private ProjectRewardCategory projectRewardCategory;

    @Column(name = "PROJECT_NAME")
//    @ColumnDefault("프로젝트 명")
    private String projectName;

    @Column(name = "PROJECT_END_DATE")
//    @Temporal(value = TemporalType.TIMESTAMP)
//    @ColumnDefault("")
    private String projectEndDate;

    @Column(name = "PROJECT_INFO")
//    @ColumnDefault("프로젝트에 대해 요약해주세요")
    private String projectInfo;             //프로젝트 요약

    @Column(name = "PROJECT_TARGET_FUND")
//    @ColumnDefault("0")
    private int projectTargetFund;

    @Column(name = "PROJECT_PROMOTION_AGREEMENT_STATUS")
    private String projectPromotionAgreementStatus;

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
                '}';
    }

    @PrePersist
    public void prePersist() {

        this.projectName = this.projectName  == null ? "프로젝트 명" : this.projectName ;
        this.projectEndDate = this.projectEndDate  == null ? "0000-00-00" : this.projectEndDate ;
        this.projectInfo = this.projectInfo  == null ? "프로젝트에 대해 요약해주세요" : this.projectInfo ;

    }
}
