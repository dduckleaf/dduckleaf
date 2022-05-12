package com.greedy.dduckleaf.projectnotice.entity;

import com.greedy.dduckleaf.projectnotice.dto.ProjectNoticeDTO;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "ProjectForProjectNotice")
@Table(name = "TBL_PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @Column(name = "OPEN_DATE")
    private java.sql.Date openDate;

    @Column(name = "END_DATE")
    private java.sql.Date endDate;

    @Column(name = "PROJECT_STATUS")
    private String projectStatus;

    @Column(name = "PROGRESS_STATUS")
    private int progressStatus;

    @Column(name = "FARMER_NO")
    private Integer farmerNo;

    public Project() {}

    public Project(int projectNo, String projectName, Date openDate, Date endDate, String projectStatus, int progressStatus, Integer farmerNo) {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.openDate = openDate;
        this.endDate = endDate;
        this.projectStatus = projectStatus;
        this.progressStatus = progressStatus;
        this.farmerNo = farmerNo;
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

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public int getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(int progressStatus) {
        this.progressStatus = progressStatus;
    }

    public Integer getFarmerNo() {
        return farmerNo;
    }

    public void setFarmerNo(Integer farmerNo) {
        this.farmerNo = farmerNo;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", openDate=" + openDate +
                ", endDate=" + endDate +
                ", projectStatus='" + projectStatus + '\'' +
                ", progressStatus=" + progressStatus +
                ", farmerNo=" + farmerNo +
                '}';
    }
}
