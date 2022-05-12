package com.greedy.dduckleaf.projectapplication.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "ProjectShippingInfoForProjectApplication")
@Table(name = "TBL_PROJECT_SHIPPING_FEE")
@DynamicInsert
public class ProjectShippingInfo {

    @Id
    @Column(name = "SHIPPING_FEE_NO")
    private int projectShippingInfoNo;

    @Column(name = "SHIPPING_FEE")
    private int shippingFee;

    @Column(name = "SHIPPING_DUE_DATE")
    private String shippingDueDate;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "EXTRA_SHIPPING_FEE")
    private int extraShippingFee;

    @Column(name = "EXTRA_SHIPPING_FEE_INFO")
    private String extraShippingFeeInfo;

    public ProjectShippingInfo() {
    }

    public ProjectShippingInfo(int projectShippingInfoNo, int shippingFee, String shippingDueDate, int projectNo, int extraShippingFee, String extraShippingFeeInfo) {
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
        return "ProjectShippingInfo{" +
                "projectShippingInfoNo=" + projectShippingInfoNo +
                ", shippingFee=" + shippingFee +
                ", shippingDueDate=" + shippingDueDate +
                ", projectNo=" + projectNo +
                ", extraShippingFee=" + extraShippingFee +
                '}';
    }

    @PrePersist
    public void prePersist() {

        this.shippingDueDate = this.shippingDueDate  == null ? java.sql.Date.valueOf(LocalDate.now().plusMonths(3)).toString() : this.shippingDueDate ;

    }
}