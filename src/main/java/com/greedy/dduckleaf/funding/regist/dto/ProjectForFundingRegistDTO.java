package com.greedy.dduckleaf.funding.regist.dto;

public class ProjectForFundingRegistDTO {
    private int projectNo;
    private String projectName;
    private RewardInfoDTO rewardInfo;
    private ProjectShippingFeeDTO projectShippingFee;

    public ProjectForFundingRegistDTO() {
    }

    public ProjectForFundingRegistDTO(int projectNo, String projectName, RewardInfoDTO rewardInfo, ProjectShippingFeeDTO projectShippingFee) {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.rewardInfo = rewardInfo;
        this.projectShippingFee = projectShippingFee;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public RewardInfoDTO getRewardInfo() {
        return rewardInfo;
    }

    public void setRewardInfo(RewardInfoDTO rewardInfo) {
        this.rewardInfo = rewardInfo;
    }

    public ProjectShippingFeeDTO getProjectShippingFee() {
        return projectShippingFee;
    }

    public void setProjectShippingFee(ProjectShippingFeeDTO projectShippingFee) {
        this.projectShippingFee = projectShippingFee;
    }

    @Override
    public String toString() {
        return "ProjectForFundingRegistDTO{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", rewardInfo=" + rewardInfo +
                ", projectShippingFee=" + projectShippingFee +
                '}';
    }
}
