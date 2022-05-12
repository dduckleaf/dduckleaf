package com.greedy.dduckleaf.projectapplication.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity(name = "ProjectApplyFeeInfoForProjectApplication")
@Table(name = "TBL_PROJECT_APPLY_FEE_INFO")
@DynamicInsert
public class ProjectApplyFeeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_APPLY_FEE_INFO_NO")
    private int projectApplyFeeInfoNo;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "FEE_POLICY_RATE_NO")
    private int feePolicyRateNo;

    public ProjectApplyFeeInfo() {
    }

    public ProjectApplyFeeInfo(int projectApplyFeeInfoNo, int projectNo, int feePolicyRateNo) {
        this.projectApplyFeeInfoNo = projectApplyFeeInfoNo;
        this.projectNo = projectNo;
        this.feePolicyRateNo = feePolicyRateNo;
    }

    public int getProjectApplyFeeInfoNo() {
        return projectApplyFeeInfoNo;
    }

    public void setProjectApplyFeeInfoNo(int projectApplyFeeInfoNo) {
        this.projectApplyFeeInfoNo = projectApplyFeeInfoNo;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public int getFeePolicyRateNo() {
        return feePolicyRateNo;
    }

    public void setFeePolicyRateNo(int feePolicyRateNo) {
        this.feePolicyRateNo = feePolicyRateNo;
    }

    @Override
    public String toString() {
        return "ProjectApplyFeeInfo{" +
                "projectApplyFeeInfoNo=" + projectApplyFeeInfoNo +
                ", projectNo=" + projectNo +
                ", feePolicyRateNo=" + feePolicyRateNo +
                '}';
    }
}
