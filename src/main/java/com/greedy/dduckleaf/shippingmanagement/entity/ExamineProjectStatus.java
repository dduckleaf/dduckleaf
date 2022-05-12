package com.greedy.dduckleaf.shippingmanagement.entity;

import javax.persistence.*;

import java.util.List;

@Entity(name = "ShippingForExamineProjectStatus")
@Table(name = "TBL_EXAMINE_PROJECT_STATUS")
public class ExamineProjectStatus {

    @Id
    @Column(name = "EXAMINE_PROJECT_STATUS_CODE")
    private int examineProjectStatusCode;       //심사중 프로젝트 상태 코드

    @Column(name = "EXAMINE_PROJECT_STATUS_NAME")
    private String examineProjectStatusName;    //심사중 프로젝트 상태 이름

    @OneToMany(mappedBy = "examineStatus")
    private List<Project> projectList;          //프로젝트 엔티티 1:N 매핑

    public ExamineProjectStatus() {}

    public ExamineProjectStatus(int examineProjectStatusCode, String examineProjectStatusName, List<Project> projectList) {
        this.examineProjectStatusCode = examineProjectStatusCode;
        this.examineProjectStatusName = examineProjectStatusName;
        this.projectList = projectList;
    }

    public int getExamineProjectStatusCode() {
        return examineProjectStatusCode;
    }

    public void setExamineProjectStatusCode(int examineProjectStatusCode) {
        this.examineProjectStatusCode = examineProjectStatusCode;
    }

    public String getExamineProjectStatusName() {
        return examineProjectStatusName;
    }

    public void setExamineProjectStatusName(String examineProjectStatusName) {
        this.examineProjectStatusName = examineProjectStatusName;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    @Override
    public String toString() {
        return "ExamineProjectStatus{" +
                "examineProjectStatusCode=" + examineProjectStatusCode +
                ", examineProjectStatusName='" + examineProjectStatusName + '\'' +
                '}';
    }
}
