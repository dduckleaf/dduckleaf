package com.greedy.dduckleaf.refund.find.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "ProjectForAdminRefundingFind")
@Table(name = "TBL_PROJECT")
public class ProjectForAdminList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROGRESS_STATUS")
    private ProjectProgressStatus progressStatus;

    @Column(name = "OPEN_DATE")
    private String openDate;

    @Column(name = "END_DATE")
    private String endDate;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FARMER_NO")
    private Farmer farmer;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PROJECT_NO")
    private List<FundingCount> fundings;

    public ProjectForAdminList() {
    }

    public ProjectForAdminList(int projectNo, String projectName, ProjectProgressStatus progressStatus, String openDate, String endDate, Farmer farmer, List<FundingCount> fundings) {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.progressStatus = progressStatus;
        this.openDate = openDate;
        this.endDate = endDate;
        this.farmer = farmer;
        this.fundings = fundings;
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

    public ProjectProgressStatus getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(ProjectProgressStatus progressStatus) {
        this.progressStatus = progressStatus;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public List<FundingCount> getFundings() {
        return fundings;
    }

    public void setFundings(List<FundingCount> fundings) {
        this.fundings = fundings;
    }

    @Override
    public String toString() {
        return "ProjectForAdminList{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", progressStatus=" + progressStatus +
                ", openDate='" + openDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", farmer=" + farmer +
                '}';
    }
}
