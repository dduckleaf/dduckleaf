package com.greedy.dduckleaf.projectapplication.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "projectProgressStatusForProjectApplication")
@Table(name = "TBL_PROJECT_PROGRESS_STATUS")
public class ProjectProgressStatus {

    @Id
    @Column(name = "PROJECT_PROGRESS_STATUS_NO")
    private int projectProgressStatusNo;

    @Column(name = "PROJECT_PROGRESS_STATUS_NAME")
    private String projectProgressStatusName;

    @OneToMany(mappedBy = "progressStatus")
    private List<Project> projectList;

    public ProjectProgressStatus() {
    }

    public ProjectProgressStatus(int projectProgressStatusNo, String projectProgressStatusName, List<Project> projectList) {
        this.projectProgressStatusNo = projectProgressStatusNo;
        this.projectProgressStatusName = projectProgressStatusName;
        this.projectList = projectList;
    }

    public int getProjectProgressStatusNo() {
        return projectProgressStatusNo;
    }

    public void setProjectProgressStatusNo(int projectProgressStatusNo) {
        this.projectProgressStatusNo = projectProgressStatusNo;
    }

    public String getProjectProgressStatusName() {
        return projectProgressStatusName;
    }

    public void setProjectProgressStatusName(String projectProgressStatusName) {
        this.projectProgressStatusName = projectProgressStatusName;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    @Override
    public String toString() {
        return "ProjectProgressStatus{" +
                "projectProgressStatusNo=" + projectProgressStatusNo +
                ", projectProgressStatusName='" + projectProgressStatusName + '\'' +
                '}';
    }
}
