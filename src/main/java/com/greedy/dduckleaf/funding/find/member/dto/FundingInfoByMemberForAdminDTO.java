package com.greedy.dduckleaf.funding.find.member.dto;

public class FundingInfoByMemberForAdminDTO {

    private int memberNo;
    private String memberName;
    private int fundingCount;
    private String recentFundingdate;
    private int refundingCount;

    public FundingInfoByMemberForAdminDTO() {
    }

    public FundingInfoByMemberForAdminDTO(int memberNo, String memberName, int fundingCount, String recentFundingdate, int refundingCount) {
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.fundingCount = fundingCount;
        this.recentFundingdate = recentFundingdate;
        this.refundingCount = refundingCount;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setFundingCount(int fundingCount) {
        this.fundingCount = fundingCount;
    }

    public void setRecentFundingdate(String recentFundingdate) {
        this.recentFundingdate = recentFundingdate;
    }

    public void setRefundingCount(int refundingCount) {
        this.refundingCount = refundingCount;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public int getFundingCount() {
        return fundingCount;
    }

    public String getRecentFundingdate() {
        return recentFundingdate;
    }

    public int getRefundingCount() {
        return refundingCount;
    }

    @Override
    public String toString() {
        return "FundingInfoByMemberForAdminDTO{" +
                "memberNo=" + memberNo +
                ", memberName='" + memberName + '\'' +
                ", fundingCount=" + fundingCount +
                ", recentFundingdate='" + recentFundingdate + '\'' +
                ", refundingCount=" + refundingCount +
                '}';
    }
}
