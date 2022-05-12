package com.greedy.dduckleaf.funding.dto;

public class ProjectShippingFeeDTO {

    private int shppingFeeNo;
    private int shippingFee;
    private int extraShippingFee;
    private String extraShippingFeeInfo;
    private int projectNo;

    public ProjectShippingFeeDTO() {
    }

    public ProjectShippingFeeDTO(int shppingFeeNo, int shippingFee, int extraShippingFee, String extraShippingFeeInfo, int projectNo) {
        this.shppingFeeNo = shppingFeeNo;
        this.shippingFee = shippingFee;
        this.extraShippingFee = extraShippingFee;
        this.extraShippingFeeInfo = extraShippingFeeInfo;
        this.projectNo = projectNo;
    }

    public int getShppingFeeNo() {
        return shppingFeeNo;
    }

    public void setShppingFeeNo(int shppingFeeNo) {
        this.shppingFeeNo = shppingFeeNo;
    }

    public int getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(int shippingFee) {
        this.shippingFee = shippingFee;
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

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    @Override
    public String toString() {
        return "ProjectShippingFeeDTO{" +
                "shppingFeeNo=" + shppingFeeNo +
                ", shippingFee=" + shippingFee +
                ", extraShippingFee=" + extraShippingFee +
                ", extraShippingFeeInfo='" + extraShippingFeeInfo + '\'' +
                ", projectNo=" + projectNo +
                '}';
    }
}
