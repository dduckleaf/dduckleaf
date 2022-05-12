package com.greedy.dduckleaf.shippingmanagement.dto;

public class RewardShippingStatusDTO {

    private int rewardShippingNo;       //발송 번호
    private String shippingDueDate;     //발송 예정일
    private int memberNo;               //회원 번호
    private ProjectDTO project;         //프로젝트 정보
    private FundingInfoDTO fundingInfo; //펀딩 신청 내역
    private int shippingStatusNo;       //발송 상태

    public RewardShippingStatusDTO() {}

    public RewardShippingStatusDTO(int rewardShippingNo, String shippingDueDate, int memberNo, ProjectDTO project, FundingInfoDTO fundingInfo, int shippingStatusNo) {
        this.rewardShippingNo = rewardShippingNo;
        this.shippingDueDate = shippingDueDate;
        this.memberNo = memberNo;
        this.project = project;
        this.fundingInfo = fundingInfo;
        this.shippingStatusNo = shippingStatusNo;
    }

    public int getRewardShippingNo() {
        return rewardShippingNo;
    }

    public void setRewardShippingNo(int rewardShippingNo) {
        this.rewardShippingNo = rewardShippingNo;
    }

    public String getShippingDueDate() {
        return shippingDueDate;
    }

    public void setShippingDueDate(String shippingDueDate) {
        this.shippingDueDate = shippingDueDate;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    public FundingInfoDTO getFundingInfo() {
        return fundingInfo;
    }

    public void setFundingInfo(FundingInfoDTO fundingInfo) {
        this.fundingInfo = fundingInfo;
    }

    public int getShippingStatusNo() {
        return shippingStatusNo;
    }

    public void setShippingStatusNo(int shippingStatusNo) {
        this.shippingStatusNo = shippingStatusNo;
    }

    @Override
    public String toString() {
        return "RewardShippingStatusDTO{" +
                "rewardShippingNo=" + rewardShippingNo +
                ", shippingDueDate='" + shippingDueDate + '\'' +
                ", memberNo=" + memberNo +
                ", project=" + project +
                ", fundingInfo=" + fundingInfo +
                ", shippingStatusNo=" + shippingStatusNo +
                '}';
    }
}
