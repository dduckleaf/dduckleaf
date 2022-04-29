package com.greedy.dduckleaf.project.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

/**
 * <pre>
 * Class : Project
 * Comment :
 *
 * History
 * 2022-04-27 username
 * </pre>
 *
 * @author username
 * @version 1.0.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "ProjectForDetail")
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
    private int progressStatus;

    @Column(name = "MAX_TARGET_AMOUNT")
    private int maxTargetAmount;

//    @ManyToOne(cascade = {CascadeType.PERSIST})
//    @JoinColumn(name = "FARMER_NO")
//    private Member farmer;
}
