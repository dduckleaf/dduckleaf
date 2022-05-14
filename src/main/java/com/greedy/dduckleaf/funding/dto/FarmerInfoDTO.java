package com.greedy.dduckleaf.funding.dto;

public class FarmerInfoDTO {

    private int memberNo;
    private String businessName;
    private String farmerName;

    public FarmerInfoDTO() {
    }

    public FarmerInfoDTO(int memberNo, String businessName, String farmerName) {
        this.memberNo = memberNo;
        this.businessName = businessName;
        this.farmerName = farmerName;
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

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }
}
