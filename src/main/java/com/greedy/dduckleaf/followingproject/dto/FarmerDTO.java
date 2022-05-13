package com.greedy.dduckleaf.followingproject.dto;

public class FarmerDTO {

    private int memberNo;
    private String businessName;

    public FarmerDTO(int memberNo, String businessName) {
        this.memberNo = memberNo;
        this.businessName = businessName;
    }

    public FarmerDTO() {
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    @Override
    public String toString() {
        return "FarmerDTO{" +
                "memberNo=" + memberNo +
                ", businessName='" + businessName + '\'' +
                '}';
    }
}
