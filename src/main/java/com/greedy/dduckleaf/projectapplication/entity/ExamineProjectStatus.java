package com.greedy.dduckleaf.projectapplication.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "ExamineProjectStatusForProjectApplication")
@Table(name = "TBL_EXAMINE_PROJECT_STATUS")
@DynamicInsert
public class ExamineProjectStatus {

    @Id
    @Column(name = "EXAMINE_PROJECT_STATUS_CODE")
    private int examineProjectStatusCode;

    @Column(name = "EXAMINE_PROJECT_STATUS_NAME")
    private String examineProjectStatusName;

    public ExamineProjectStatus() {
    }

    public ExamineProjectStatus(int examineProjectStatusCode, String examineProjectStatusName) {
        this.examineProjectStatusCode = examineProjectStatusCode;
        this.examineProjectStatusName = examineProjectStatusName;
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

    @Override
    public String toString() {
        return "ExamineProjectStatus{" +
                "examineProjectStatusCode=" + examineProjectStatusCode +
                ", examineProjectStatusName='" + examineProjectStatusName + '\'' +
                '}';
    }
}
