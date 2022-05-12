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

    @Column(name = "PROGRESS_STATUS")
    private int progressStatus;

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
}
