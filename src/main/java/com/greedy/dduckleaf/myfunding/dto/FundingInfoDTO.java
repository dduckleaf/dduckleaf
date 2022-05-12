package com.greedy.dduckleaf.myfunding.dto;

public class FundingInfoDTO {

    private int fundingInfoNo;
    private int projectNo;
    private int memberNo;

    public FundingInfoDTO() {
    }

    public FundingInfoDTO(int fundingInfoNo, int projectNo, int memberNo) {
        this.fundingInfoNo = fundingInfoNo;
        this.projectNo = projectNo;
        this.memberNo = memberNo;
    }

    public int getFundingInfoNo() {
        return fundingInfoNo;
    }

    public void setFundingInfoNo(int fundingInfoNo) {
        this.fundingInfoNo = fundingInfoNo;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    @Override
    public String toString() {
        return "FundingInfoDTO{" +
                "fundingInfoNo=" + fundingInfoNo +
                ", projectNo=" + projectNo +
                ", memberNo=" + memberNo +
                '}';
    }
}
