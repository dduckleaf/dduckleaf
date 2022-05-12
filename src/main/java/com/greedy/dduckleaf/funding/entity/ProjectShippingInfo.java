package com.greedy.dduckleaf.funding.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "ProjectShippingInfoForFundingRegsit")
@Table(name = "TBL_PROJECT_SHIPPING_FEE")
public class ProjectShippingInfo {

    @Id
    @Column(name = "PROJECT_NO")
    private int projectdNo;

    @Column(name = "SHIPPING_DUE_DATE")
    private String shippingDueDate;

    public ProjectShippingInfo() {
    }

    public ProjectShippingInfo(int projectdNo, String shippingDueDate) {
        this.projectdNo = projectdNo;
        this.shippingDueDate = shippingDueDate;
    }

    public int getProjectdNo() {
        return projectdNo;
    }

    public void setProjectdNo(int projectdNo) {
        this.projectdNo = projectdNo;
    }

    public String getShippingDueDate() {
        return shippingDueDate;
    }

    public void setShippingDueDate(String shippingDueDate) {
        this.shippingDueDate = shippingDueDate;
    }

    @Override
    public String toString() {
        return "ProjectShippingInfo{" +
                "projectdNo=" + projectdNo +
                ", shippingDueDate='" + shippingDueDate + '\'' +
                '}';
    }
}
