package com.greedy.dduckleaf.projectreport.find.dto;

public class FarmerInfoDTO {

    private int memberNo;
    private String farmerName;

    public FarmerInfoDTO() {}

    public FarmerInfoDTO(int memberNo, String farmerName) {
        this.memberNo = memberNo;
        this.farmerName = farmerName;
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

    @Override
    public String toString() {
        return "FarmerInfoDTO{" +
                "memberNo=" + memberNo +
                ", farmerName='" + farmerName + '\'' +
                '}';
    }
}
