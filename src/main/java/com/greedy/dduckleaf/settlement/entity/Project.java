package com.greedy.dduckleaf.settlement.entity;

import javax.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "ProjectForSettlement")
@Table(name = "TBL_PROJECT")
public class Project {

    @Id
    @Column(name = "PROJECT_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectNo;                              //프로젝트번호

    @Column(name = "PROJECT_NAME")
    private String projectName;                         //프로젝트명

    @Column(name = "PROGRESS_STATUS")
    private int progressStatus;                      //진행상태

    @Column(name = "PROJECT_STATUS")
    private String projectStatus;                       //취소여부

    @Column(name = "ACHIEVEMENT_RATE")
    private int achievementRate;                        //달성률

    @Column(name = "FUND_TARGET_AMOUNT")
    private int fundTargetAmount;                       //목표펀딩금액

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FARMER_NO")
    private FarmerInfo farmer;                          //파머정보

    @Column(name = "OPEN_DATE")
    private String openDate;                            //오픈일

    @Column(name = "END_DATE")
    private String endDate;                             //종료일

    @Transient
    @Column(name = "EXAMINE_STATUS")
    private String examineStatus;                       //심사상태

    @Transient
    @Column(name = "PROJECT_EXAMINE_STATUS")
    private String projectExamineStatus;                //심사결과

//    @Transient
    @Column(name = "MAX_TARGET_AMOUNT")
    private int maxTargetAmount;                        //목표최대금액

    @Override
    public String toString() {
        return "Project{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", progressStatus='" + progressStatus + '\'' +
                ", projectStatus='" + projectStatus + '\'' +
                ", achievementRate=" + achievementRate +
                ", fundTargetAmount=" + fundTargetAmount +
                ", farmer=" + farmer +
                ", openDate='" + openDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", examineStatus='" + examineStatus + '\'' +
                ", projectExamineStatus='" + projectExamineStatus + '\'' +
                ", maxTargetAmount=" + maxTargetAmount +
                '}';
    }
}
