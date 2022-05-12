package com.greedy.dduckleaf.projectapplication.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "ProjectExamineHistoryForProjectExamination")
@Table(name = "TBL_PROJECT_EXAMINE_HISTORY")
@DynamicInsert
public class ProjectExamineHistory {

    @Id
    @Column(name = "PROJECT_EXAMINE_HISTORY_NO")
    private int projectExamineHistoryNo;

    @Column(name = "EXAMINE_HISTORY_CATEGORY_NO")
    private int examineHistoryCategory;       //프로젝트 승인 이력 구분 번호

    @Column(name = "PROJECT_EXAMINE_DETAIL_CONTENT")
    private String projectExamineDetailContent;

    @Column(name = "PROJECT_EXAMINE_REGIST_DATE")
    private String projectExamineRegistDate;

    @Column(name = "EXAMINE_PROJECT_STATUS_CODE")
    private int examineProjectStatus;

    @Column(name = "FARMER_NO")
    private int farmerNo;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "ADMIN_NO")
    private int adminNo;

    public ProjectExamineHistory() {
    }

    public ProjectExamineHistory(int projectExamineHistoryNo, int examineHistoryCategory, String projectExamineDetailContent, String projectExamineRegistDate, int examineProjectStatus, int farmerNo, int projectNo, int adminNo) {
        this.projectExamineHistoryNo = projectExamineHistoryNo;
        this.examineHistoryCategory = examineHistoryCategory;
        this.projectExamineDetailContent = projectExamineDetailContent;
        this.projectExamineRegistDate = projectExamineRegistDate;
        this.examineProjectStatus = examineProjectStatus;
        this.farmerNo = farmerNo;
        this.projectNo = projectNo;
        this.adminNo = adminNo;
    }

    public int getProjectExamineHistoryNo() {
        return projectExamineHistoryNo;
    }

    public void setProjectExamineHistoryNo(int projectExamineHistoryNo) {
        this.projectExamineHistoryNo = projectExamineHistoryNo;
    }

    public int getExamineHistoryCategory() {
        return examineHistoryCategory;
    }

    public void setExamineHistoryCategory(int examineHistoryCategory) {
        this.examineHistoryCategory = examineHistoryCategory;
    }

    public String getProjectExamineDetailContent() {
        return projectExamineDetailContent;
    }

    public void setProjectExamineDetailContent(String projectExamineDetailContent) {
        this.projectExamineDetailContent = projectExamineDetailContent;
    }

    public String getProjectExamineRegistDate() {
        return projectExamineRegistDate;
    }

    public void setProjectExamineRegistDate(String projectExamineRegistDate) {
        this.projectExamineRegistDate = projectExamineRegistDate;
    }

    public int getExamineProjectStatus() {
        return examineProjectStatus;
    }

    public void setExamineProjectStatus(int examineProjectStatus) {
        this.examineProjectStatus = examineProjectStatus;
    }

    public int getFarmerNo() {
        return farmerNo;
    }

    public void setFarmerNo(int farmerNo) {
        this.farmerNo = farmerNo;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public int getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(int adminNo) {
        this.adminNo = adminNo;
    }

    @Override
    public String toString() {
        return "ProjectExamineHistory{" +
                "projectExamineHistoryNo=" + projectExamineHistoryNo +
                ", examineHistoryCategory=" + examineHistoryCategory +
                ", projectExamineDetailContent='" + projectExamineDetailContent + '\'' +
                ", projectExamineRegistDate='" + projectExamineRegistDate + '\'' +
                ", examineProjectStatus=" + examineProjectStatus +
                ", farmerNo=" + farmerNo +
                ", projectNo=" + projectNo +
                ", adminNo=" + adminNo +
                '}';
    }
}
