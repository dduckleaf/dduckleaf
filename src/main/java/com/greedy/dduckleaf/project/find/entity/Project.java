package com.greedy.dduckleaf.project.find.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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

    @Column(name = "PROGRESS_STATUS")
    private int progressStatus;

    @Column(name = "MAX_TARGET_AMOUNT")
    private int maxTargetAmount;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "FARMER_NO")
    private Member farmer;

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
                ", farmer=" + farmer +
                '}';
    }
}
