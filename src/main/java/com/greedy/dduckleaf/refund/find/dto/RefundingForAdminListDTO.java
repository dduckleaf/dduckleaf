package com.greedy.dduckleaf.refund.find.dto;

public class RefundingForAdminListDTO {

    private int refundingInfoNo;
    private int projectNo;
    private String projectName;
    private String farmerName;
    private String refundStatus;
    private String refundingDate;
    private String refundingEndDate;

    public RefundingForAdminListDTO() {
    }

    public RefundingForAdminListDTO(int refundingInfoNo, int projectNo, String projectName, String farmerName, String refundStatus, String refundingDate, String refundingEndDate) {
        this.refundingInfoNo = refundingInfoNo;
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.farmerName = farmerName;
        this.refundStatus = refundStatus;
        this.refundingDate = refundingDate;
        this.refundingEndDate = refundingEndDate;
    }

    public int getRefundingInfoNo() {
        return refundingInfoNo;
    }

    public void setRefundingInfoNo(int refundingInfoNo) {
        this.refundingInfoNo = refundingInfoNo;
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

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getRefundingDate() {
        return refundingDate;
    }

    public void setRefundingDate(String refundingDate) {
        this.refundingDate = refundingDate;
    }

    public String getRefundingEndDate() {
        return refundingEndDate;
    }

    public void setRefundingEndDate(String refundingEndDate) {
        this.refundingEndDate = refundingEndDate;
    }

    @Override
    public String toString() {
        return "RefundingForAdminListDTO{" +
                "refundingInfoNo=" + refundingInfoNo +
                ", projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", farmerName='" + farmerName + '\'' +
                ", refundStatus='" + refundStatus + '\'' +
                ", refundingDate='" + refundingDate + '\'' +
                ", refundingEndDate='" + refundingEndDate + '\'' +
                '}';
    }
}