package com.greedy.dduckleaf.funding.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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
    private java.sql.Date openDate;

    @Column(name = "END_DATE")
    private java.sql.Date endDate;

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
    private ProjectShippingFee projectShippingFee;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_NO")
    private List<ProjectRegistInfo> registInfo;

    @OneToMany(mappedBy = "project")
    private List<Funding> fundingList;

    @Override
    public String toString() {
        return "Project{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", fundTargetAmount=" + fundTargetAmount +
                ", openDate=" + openDate +
                ", endDate=" + endDate +
                ", projectStatus='" + projectStatus + '\'' +
                ", achievementRate=" + achievementRate +
                ", examineStatus='" + examineStatus + '\'' +
                ", projectExamineStatus='" + projectExamineStatus + '\'' +
                ", progressStatus='" + progressStatus + '\'' +
                ", maxTargetAmount=" + maxTargetAmount +
                ", rewardInfo=" + rewardInfo +
                ", projectShippingFee=" + projectShippingFee +
                ", registInfo=" + registInfo +
                '}';
    }
}