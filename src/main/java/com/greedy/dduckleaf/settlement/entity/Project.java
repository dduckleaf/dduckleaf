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
    private int projectNo;                  //프로젝트 번호

    @Column(name = "PROJECT_NAME")
    private String projectName;             //프로젝트명

    @Column(name = "OPEN_DATE")
    private String openDate;                //오픈일

    @Column(name = "END_DATE")
    private String endDate;                 //종료일

    @Column(name = "ACHIEVEMENT_RATE")
    private int achievementRate;            //달성률

    @Column(name = "PROJECT_STATUS")
    private String projectStatus;           //승인여부

    @Column(name = "PROGRESS_STATUS")
    private int progressStatus;             //진행상태

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FARMER_NO")
    private FarmerInfo farmer;              //파머번호

    @Override
    public String toString() {
        return "Project{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", openDate='" + openDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", achievementRate='" + achievementRate + '\'' +
                ", progressStatus='" + progressStatus + '\'' +
                ", farmer=" + farmer +
                '}';
    }
}
