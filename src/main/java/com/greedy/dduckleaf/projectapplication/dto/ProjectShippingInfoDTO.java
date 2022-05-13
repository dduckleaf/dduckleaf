package com.greedy.dduckleaf.projectapplication.dto;

import javax.persistence.Column;

public class ProjectShippingInfoDTO {

    private int projectShippingInfoNo;
    private int shippingFee;
    private String shippingDueDate;
    private int projectNo;
    private int extraShippingFee;
    private String extraShippingFeeInfo;

    public ProjectShippingInfoDTO() {}

    public ProjectShippingInfoDTO(int projectShippingInfoNo, int shippingFee, String shippingDueDate, int projectNo, int extraShippingFee, String extraShippingFeeInfo) {
        this.projectShippingInfoNo = projectShippingInfoNo;
        this.shippingFee = shippingFee;
        this.shippingDueDate = shippingDueDate;
        this.projectNo = projectNo;
        this.extraShippingFee = extraShippingFee;
        this.extraShippingFeeInfo = extraShippingFeeInfo;
    }

    public int getProjectShippingInfoNo() {
        return projectShippingInfoNo;
    }

    public void setProjectShippingInfoNo(int projectShippingInfoNo) {
        this.projectShippingInfoNo = projectShippingInfoNo;
    }

    public int getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(int shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getShippingDueDate() {
        return shippingDueDate;
    }

    public void setShippingDueDate(String shippingDueDate) {
        this.shippingDueDate = shippingDueDate;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public int getExtraShippingFee() {
        return extraShippingFee;
    }

    public void setExtraShippingFee(int extraShippingFee) {
        this.extraShippingFee = extraShippingFee;
    }

    public String getExtraShippingFeeInfo() {
        return extraShippingFeeInfo;
    }

    public void setExtraShippingFeeInfo(String extraShippingFeeInfo) {
        this.extraShippingFeeInfo = extraShippingFeeInfo;
    }

    @Override
    public String toString() {
        return "ProjectShippingInfoDTO{" +
                "projectShippingInfoNo=" + projectShippingInfoNo +
                ", shippingFee=" + shippingFee +
                ", shippingDueDate='" + shippingDueDate + '\'' +
                ", projectNo=" + projectNo +
                ", extraShippingFee=" + extraShippingFee +
                ", extraShippingFeeInfo='" + extraShippingFeeInfo + '\'' +
                '}';
    }

}
