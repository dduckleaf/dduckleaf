package com.greedy.dduckleaf.projectreport.find.entity;

import javax.persistence.*;

@Entity(name = "ProjectForProjectReport")
@Table(name = "TBL_PROJECT")
public class Project {

    @Id
    @Column(name = "PROJECT_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectNo;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    public Project() {}

    public Project(int projectNo, String projectName) {
        this.projectNo = projectNo;
        this.projectName = projectName;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                '}';
    }

    //    @Column(name = "FUND_TARGET_AMOUNT")
//    private int fundTargetAmount;
//
//    @Column(name = "OPEN_DATE")
//    private Date openDate;
//
//    @Column(name = "END_DATE")
//    private Date endDate;
//
//    @Column(name = "PROJECT_STATUS")
//    private String projectStatus;
//
//    @Column(name = "ACHIEVEMENT_RATE")
//    private int achievementRate;
//
//    @Column(name = "EXAMINE_STATUS")
//    private String examineStatus;
//
//    @Column(name = "PROJECT_EXAMINE_STATUS")
//    private String projectExamineStatus;
//
//    @Column(name = "PROGRESS_STATUS")
//    private String progressStatus;
//
//    @Column(name = "MAX_TARGET_AMOUNT")
//    private int maxTargetAmount;
//
//    @JoinColumn(name = "FARMER_NO")
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    private FarmerInfo farmerInfo;

}
