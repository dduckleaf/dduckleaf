package com.greedy.dduckleaf.projectreport.find.dto;

public class FarmerInfoDTO {

    private int memberNo;
    private String farmerName;
    private String businessName;

    public FarmerInfoDTO() {}

    public FarmerInfoDTO(int memberNo, String farmerName, String businessName) {
        this.memberNo = memberNo;
        this.farmerName = farmerName;
        this.businessName = businessName;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    @Override
    public String toString() {
        return "FarmerInfo{" +
                "memberNo=" + memberNo +
                ", farmerName='" + farmerName + '\'' +
                ", businessName='" + businessName + '\'' +
                '}';
    }
}
