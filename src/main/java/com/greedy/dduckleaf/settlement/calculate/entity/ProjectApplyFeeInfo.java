package com.greedy.dduckleaf.settlement.calculate.entity;

import javax.persistence.*;

@Entity(name = "ProjectApplyFeeInfoForSettlementCalculate")
@Table(name = "TBL_PROJECT_APPLY_FEE_INFO")
public class ProjectApplyFeeInfo {

    @Id
    @Column(name = "PROJECT_APPLY_FEE_INFO_NO")
    private int projectApplyFeeInfoNo;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FEE_POLICY_RATE_NO")
    private FeePolicy feePolicy;

    public ProjectApplyFeeInfo() {}

    public ProjectApplyFeeInfo(int projectApplyFeeInfoNo, int projectNo, FeePolicy feePolicy) {
        this.projectApplyFeeInfoNo = projectApplyFeeInfoNo;
        this.projectNo = projectNo;
        this.feePolicy = feePolicy;
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

    public FeePolicy getFeePolicy() {
        return feePolicy;
    }

    public void setFeePolicy(FeePolicy feePolicy) {
        this.feePolicy = feePolicy;
    }

    @Override
    public String toString() {
        return "ProjectApplyFeeInfo{" +
                "projectApplyFeeInfoNo=" + projectApplyFeeInfoNo +
                ", projectNo=" + projectNo +
                ", feePolicy=" + feePolicy +
                '}';
    }
}
