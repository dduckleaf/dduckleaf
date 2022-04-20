package com.greedy.dduckleaf.funding.entity;

import javax.persistence.*;

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

    @Column(name = "PROJECT_EXAMINE_STAUTS")
    private String projectExamineStatus;

    @Column(name = "PROGRESS_STATUS")
    private String progressStatus;

    @Column(name = "MAX_TARGET_AMOUNT")
    private int maxTargetAmount;


}
