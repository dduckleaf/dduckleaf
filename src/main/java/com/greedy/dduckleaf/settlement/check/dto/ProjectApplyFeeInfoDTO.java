package com.greedy.dduckleaf.settlement.check.dto;

public class ProjectApplyFeeInfoDTO {

    private int projectApplyFeeInfoNo;
    private int projectNo;
    private FeePolicyDTO feePolicy;

    public ProjectApplyFeeInfoDTO() {}

    public ProjectApplyFeeInfoDTO(int projectApplyFeeInfoNo, int projectNo, FeePolicyDTO feePolicy) {
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

    public FeePolicyDTO getFeePolicy() {
        return feePolicy;
    }

    public void setFeePolicy(FeePolicyDTO feePolicy) {
        this.feePolicy = feePolicy;
    }

    @Override
    public String toString() {
        return "ProjectApplyFeeInfoDTO{" +
                "projectApplyFeeInfoNo=" + projectApplyFeeInfoNo +
                ", projectNo=" + projectNo +
                ", feePolicy=" + feePolicy +
                '}';
    }
}
