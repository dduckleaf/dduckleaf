package com.greedy.dduckleaf.funding.entity;

import javax.persistence.*;

import lombok.*;

@Entity(name = "ProjectShippingFeeForFundingRegist")
@Table(name = "TBL_PROJECT_SHIPPING_FEE")
public class ProjectShippingFee {

    @Id
    @Column(name = "SHIPPING_FEE_NO")
    private int shppingFeeNo;


    @Column(name = "SHIPPING_FEE")
    private int shippingFee;

    @Column(name = "EXTRA_SHIPPING_FEE")
    private int extraShippingFee;


    @Column(name = "EXTRA_SHIPPING_FEE_INFO")
    private String extraShippingFeeInfo;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    public ProjectShippingFee() {
    }

    public ProjectShippingFee(int shppingFeeNo, int shippingFee, int extraShippingFee, String extraShippingFeeInfo, int projectNo) {
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
        return "ProjectShippingFee{" +
                "shppingFeeNo=" + shppingFeeNo +
                ", shippingFee=" + shippingFee +
                ", extraShippingFee=" + extraShippingFee +
                ", extraShippingFeeInfo='" + extraShippingFeeInfo + '\'' +
                ", projectNo=" + projectNo +
                '}';
    }
}
