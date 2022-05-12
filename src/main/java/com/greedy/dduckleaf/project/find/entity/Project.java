package com.greedy.dduckleaf.project.find.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "ProjectForProjectList")
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
    private Date openDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "PROJECT_STATUS")
    private String projectStatus;

    @Column(name = "ACHIEVEMENT_RATE")
    private double achievementRate;

    @Column(name = "EXAMINE_STATUS")
    private String examineStatus;

    @Column(name = "PROJECT_EXAMINE_STATUS")
    private String projectExamineStatus;


    @Column(name = "MAX_TARGET_AMOUNT")
    private int maxTargetAmount;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "FARMER_NO")
    private Member farmer;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "PROGRESS_STATUS")
    private ProjectProgressStatus progressStatus;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_NO")
    private ProjectBasicInfo basicInfo;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_NO")
    private List<ProjectAttachment> attachments;
}
