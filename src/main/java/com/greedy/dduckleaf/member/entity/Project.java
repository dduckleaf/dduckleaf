package com.greedy.dduckleaf.member.entity;

import javax.persistence.*;

@Entity(name = "ProjectForMember")
@Table(name = "TBL_PROJECT")
public class Project {

    @Id
    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "PROJECT_STATUS")
    private String projectStatus;

    @OneToOne
    @JoinColumn(name = "PROGRESS_STATUS")
    private ProjectProgressStatus projectProgressStatus;

    @OneToOne
    @JoinColumn(name = "FARMER_NO")
    private Farmer farmer;

    public Project() {
    }

    public Project(int projectNo, String projectStatus, ProjectProgressStatus projectProgressStatus, Farmer farmer) {
        this.projectNo = projectNo;
        this.projectStatus = projectStatus;
        this.projectProgressStatus = projectProgressStatus;
        this.farmer = farmer;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public ProjectProgressStatus getProjectProgressStatus() {
        return projectProgressStatus;
    }

    public void setProjectProgressStatus(ProjectProgressStatus projectProgressStatus) {
        this.projectProgressStatus = projectProgressStatus;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectNo=" + projectNo +
                ", projectStatus='" + projectStatus + '\'' +
                ", projectProgressStatus=" + projectProgressStatus +
                ", farmer=" + farmer +
                '}';
    }
}
