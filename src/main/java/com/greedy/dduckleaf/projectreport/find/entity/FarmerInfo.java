package com.greedy.dduckleaf.projectreport.find.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "FarmerInfoForProjectReport")
@Table(name = "TBL_FARMER_INFO")
public class FarmerInfo {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "FARMER_NAME")
    private String farmerName;

    public FarmerInfo() {}

    public FarmerInfo(int memberNo, String farmerName) {
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
        return "FarmerInfo{" +
                "memberNo=" + memberNo +
                ", farmerName='" + farmerName + '\'' +
                '}';
    }
}
