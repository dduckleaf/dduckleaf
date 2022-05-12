package com.greedy.dduckleaf.projectapplication.dto;

public class ProjectShippingInfoDTO {

    private int projectShippingInfoNo;
    private int shippingFee;
    private String shippingDueDate;
    private int projectNo;
    private int extraShippingFee;

    public ProjectShippingInfoDTO() {
    }

    public ProjectShippingInfoDTO(int projectShippingInfoNo, int shippingFee, String shippingDueDate, int projectNo, int extraShippingFee) {
        this.projectShippingInfoNo = projectShippingInfoNo;
        this.shippingFee = shippingFee;
        this.shippingDueDate = shippingDueDate;
        this.projectNo = projectNo;
        this.extraShippingFee = extraShippingFee;
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

    @Override
    public String toString() {
        return "ProjectShippingInfoDTO{" +
                "projectShippingInfoNo=" + projectShippingInfoNo +
                ", shippingFee=" + shippingFee +
                ", shippingDueDate='" + shippingDueDate + '\'' +
                ", projectNo=" + projectNo +
                ", extraShippingFee=" + extraShippingFee +
                '}';
    }
}
