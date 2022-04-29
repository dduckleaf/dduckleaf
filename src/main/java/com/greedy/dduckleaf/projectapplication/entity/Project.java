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

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "ProjectForProjectApplication")
@Table(name = "TBL_PROJECT")
//@DynamicInsert
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "PROJECT_NAME")
    @ColumnDefault(value = "'프로젝트 명'")
    private String projectName;

    @Column(name = "FUND_TARGET_AMOUNT")
    @ColumnDefault(value = "0")
    private int fundTargetAmount;

    @Column(name = "OPEN_DATE")
//    @Temporal(value = TemporalType.TIMESTAMP)
    @ColumnDefault("")
    private String openDate;

    @Column(name = "END_DATE")
    //    @Temporal(value = TemporalType.TIMESTAMP)
    @ColumnDefault("NOW()")
    private String endDate;

    @Column(name = "PROJECT_STATUS")
    @ColumnDefault(value = "'N'")
    private String projectStatus;

    @Column(name = "ACHIEVEMENT_RATE")
    @ColumnDefault(value = "0")
    private double achievementRate;

    @Column(name = "EXAMINE_STATUS")
    @ColumnDefault(value = "'1'")
    private String examineStatus;               //심사상태

    @Column(name = "PROJECT_EXAMINE_STATUS")
    private String projectExamineStatus;        //심사결과

    @Column(name = "PROGRESS_STATUS")
    @ColumnDefault(value = "1")
    private int progressStatus;

    @Column(name = "MAX_TARGET_AMOUNT")
    @ColumnDefault(value = "0")
    private int maxTargetAmount;

//    @ManyToOne(cascade = CascadeType.ALL)
    @Column(name = "FARMER_NO")
    private int farmerNo;

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
                ", progressStatus=" + progressStatus +
                ", maxTargetAmount=" + maxTargetAmount +
                ", farmerNo=" + farmerNo +
                '}';
    }

    @PrePersist
    public void prePersist() {

        this.projectName = this.projectName  == null ? "프로젝트 명" : this.projectName ;
        this.openDate = this.openDate  == null ? java.sql.Date.valueOf(LocalDate.now()).toString() : this.openDate ;
        this.endDate = this.endDate  == null ? java.sql.Date.valueOf(LocalDate.now().plusMonths(1)).toString() : this.endDate ;
        this.examineStatus = this.examineStatus  == null ? "1" : this.examineStatus ;
        this.projectStatus = this.projectStatus  == null ? "Y" : this.projectStatus ;

    }
}
