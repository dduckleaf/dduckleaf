package com.greedy.dduckleaf.projectapplication.dto;

public class ProjectApplicationInfoDTO {                        //프로젝트 신청 내역

    private int projectApplicationNo;
    private String projectApplicationCategory;                  //구분
    private ProjectBasicInfoDTO projectBasicInfo;               //기본 정보 번호
    private ProjectShippingInfoDTO projectShippingInfo;         //발송 정보 번호
    private RewardRegistInfoDTO rewardRegistInfo;               //리워드 등록 정보 번호
    private RefundPolicyDTO refundPolicy;                       //환불 정책 번호
    private ProjectDTO project;
    private FarmerInfoDTO farmer;

    public ProjectApplicationInfoDTO() {
    }

    public ProjectApplicationInfoDTO(int projectApplicationNo, String projectApplicationCategory, ProjectBasicInfoDTO projectBasicInfo, ProjectShippingInfoDTO projectShippingInfo, RewardRegistInfoDTO rewardRegistInfo, RefundPolicyDTO refundPolicy, ProjectDTO project, FarmerInfoDTO farmer) {
        this.projectApplicationNo = projectApplicationNo;
        this.projectApplicationCategory = projectApplicationCategory;
        this.projectBasicInfo = projectBasicInfo;
        this.projectShippingInfo = projectShippingInfo;
        this.rewardRegistInfo = rewardRegistInfo;
        this.refundPolicy = refundPolicy;
        this.project = project;
        this.farmer = farmer;
    }

    public int getProjectApplicationNo() {
        return projectApplicationNo;
    }

    public void setProjectApplicationNo(int projectApplicationNo) {
        this.projectApplicationNo = projectApplicationNo;
    }

    public String getProjectApplicationCategory() {
        return projectApplicationCategory;
    }

    public void setProjectApplicationCategory(String projectApplicationCategory) {
        this.projectApplicationCategory = projectApplicationCategory;
    }

    public ProjectBasicInfoDTO getProjectBasicInfo() {
        return projectBasicInfo;
    }

    public void setProjectBasicInfo(ProjectBasicInfoDTO projectBasicInfo) {
        this.projectBasicInfo = projectBasicInfo;
    }

    public ProjectShippingInfoDTO getProjectShippingInfo() {
        return projectShippingInfo;
    }

    public void setProjectShippingInfo(ProjectShippingInfoDTO projectShippingInfo) {
        this.projectShippingInfo = projectShippingInfo;
    }

    public RewardRegistInfoDTO getRewardRegistInfo() {
        return rewardRegistInfo;
    }

    public void setRewardRegistInfo(RewardRegistInfoDTO rewardRegistInfo) {
        this.rewardRegistInfo = rewardRegistInfo;
    }

    public RefundPolicyDTO getRefundPolicy() {
        return refundPolicy;
    }

    public void setRefundPolicy(RefundPolicyDTO refundPolicy) {
        this.refundPolicy = refundPolicy;
    }

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    public FarmerInfoDTO getFarmer() {
        return farmer;
    }

    public void setFarmer(FarmerInfoDTO farmer) {
        this.farmer = farmer;
    }

    @Override
    public String toString() {
        return "ProjectApplicationInfoDTO{" +
                "projectApplicationNo=" + projectApplicationNo +
                ", projectApplicationCategory='" + projectApplicationCategory + '\'' +
                ", projectBasicInfo=" + projectBasicInfo +
                ", projectShippingInfo=" + projectShippingInfo +
                ", rewardRegistInfo=" + rewardRegistInfo +
                ", refundPolicy=" + refundPolicy +
                ", project=" + project +
                ", farmer=" + farmer +
                '}';
    }
}
