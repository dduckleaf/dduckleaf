package com.greedy.dduckleaf.projectapplication.entity;

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
@Entity(name = "ProjectForProjectApplication")
@Table(name = "TBL_PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_NO")
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
    private String examineStatus;               //심사상태

    @Column(name = "PROJECT_EXAMINE_STATUS")
    private String projectExamineStatus;        //심사결과

    @Column(name = "PROGRESS_STATUS")
    private int progressStatus;

    @Column(name = "MAX_TARGET_AMOUNT")
    private int maxTargetAmount;

//    @ManyToOne(cascade = CascadeType.ALL)
    @Column(name = "FARMER_NO")
    private int farmerNo;

    @Override
    public String toString() {
        return "Project{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", openDate=" + openDate +
                ", endDate=" + endDate +
                ", projectStatus='" + projectStatus + '\'' +
                ", progressStatus=" + progressStatus +
                ", farmerNo=" + farmerNo +
                '}';
    }
}
