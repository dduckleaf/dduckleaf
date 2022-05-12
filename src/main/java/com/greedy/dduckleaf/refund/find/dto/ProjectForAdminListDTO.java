package com.greedy.dduckleaf.refund.find.dto;

import com.greedy.dduckleaf.refund.find.entity.Farmer;
import com.greedy.dduckleaf.refund.find.entity.ProjectProgressStatus;

public class ProjectForAdminListDTO {

    private int projectNo;
    private String projectName;
    private ProjectProgressStatus progressStatus;
    private Farmer farmer;
    private int fundingCount;
    private int refundingCount;
    private String openDate;
    private String endDate;

    public ProjectForAdminListDTO() {
    }

    public ProjectForAdminListDTO(int projectNo, String projectName, ProjectProgressStatus progressStatus, Farmer farmer, int fundingCount, int refundingCount, String openDate, String endDate) {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.progressStatus = progressStatus;
        this.farmer = farmer;
        this.fundingCount = fundingCount;
        this.refundingCount = refundingCount;
        this.openDate = openDate;
        this.endDate = endDate;
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

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public int getFundingCount() {
        return fundingCount;
    }

    public void setFundingCount(int fundingCount) {
        this.fundingCount = fundingCount;
    }

    public int getRefundingCount() {
        return refundingCount;
    }

    public void setRefundingCount(int refundingCount) {
        this.refundingCount = refundingCount;
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

    @Override
    public String toString() {
        return "ProjectForAdminListDTO{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", progressStatus=" + progressStatus +
                ", farmer=" + farmer +
                ", fundingCount=" + fundingCount +
                ", refundingCount=" + refundingCount +
                ", openDate='" + openDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}