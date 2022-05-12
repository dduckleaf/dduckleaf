package com.greedy.dduckleaf.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "ProjectProgressStatusForMain")
@Table(name = "TBL_PROJECT_PROGRESS_STATUS")
public class ProjectProgressStatus {

    @Id
    @Column(name = "PROJECT_PROGRESS_STATUS_NO")
    private int projectProgressStatusNo;

    @Column(name = "PROJECT_PROGRESS_STATUS_NAME")
    private String projectProgressStatusName;

    public ProjectProgressStatus() {
    }

    public ProjectProgressStatus(int projectProgressStatusNo, String projectProgressStatusName) {
        this.projectProgressStatusNo = projectProgressStatusNo;
        this.projectProgressStatusName = projectProgressStatusName;
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

    @Override
    public String toString() {
        return "ProjectProgressStatus{" +
                "projectProgressStatusNo=" + projectProgressStatusNo +
                ", projectProgressStatusName='" + projectProgressStatusName + '\'' +
                '}';
    }
}
