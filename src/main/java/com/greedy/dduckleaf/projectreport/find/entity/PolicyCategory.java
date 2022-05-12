package com.greedy.dduckleaf.projectreport.find.entity;

import javax.persistence.*;

@Entity(name = "PolicyCategoryForProjectReport")
@Table(name = "TBL_POLICY_CATEGORY")
public class PolicyCategory {

    @Id
    @Column(name = "POLICY_CATEGORY_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int policyCategoryNo;                       //구분번호

    @Column(name = "POLICY_CATEGORY_NAME")
    private String policyCategoryName;                  //구분명

    public PolicyCategory() {}

    public PolicyCategory(int policyCategoryNo, String policyCategoryName) {
        this.policyCategoryNo = policyCategoryNo;
        this.policyCategoryName = policyCategoryName;
    }

    public int getPolicyCategoryNo() {
        return policyCategoryNo;
    }

    public void setPolicyCategoryNo(int policyCategoryNo) {
        this.policyCategoryNo = policyCategoryNo;
    }

    public String getPolicyCategoryName() {
        return policyCategoryName;
    }

    public void setPolicyCategoryName(String policyCategoryName) {
        this.policyCategoryName = policyCategoryName;
    }

    @Override
    public String toString() {
        return "PolicyCategory{" +
                "policyCategoryNo=" + policyCategoryNo +
                ", policyCategoryName='" + policyCategoryName + '\'' +
                '}';
    }
}
