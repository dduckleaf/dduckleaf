package com.greedy.dduckleaf.settlement.entity;

import javax.persistence.*;

@Entity(name = "FarmerInfoForSettlement")
@Table(name = "TBL_FARMER_INFO")
public class FarmerInfo {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;                               //회원번호

    @Column(name = "FARMER_NAME")
    private String farmerName;                          //파머 이름

    @Column(name = "REPRESENTATIVE_NAME")
    private String representativeName;                  //대표자명

    @Column(name = "REPRESENTATIVE_EMAIL")
    private String representativeEmail;                 //대표자이메일

    public FarmerInfo() {}

    public FarmerInfo(int memberNo, String farmerName, String representativeName, String representativeEmail) {
        this.memberNo = memberNo;
        this.farmerName = farmerName;
        this.representativeName = representativeName;
        this.representativeEmail = representativeEmail;
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

    public String getRepresentativeName() {
        return representativeName;
    }

    public void setRepresentativeName(String representativeName) {
        this.representativeName = representativeName;
    }

    public String getRepresentativeEmail() {
        return representativeEmail;
    }

    public void setRepresentativeEmail(String representativeEmail) {
        this.representativeEmail = representativeEmail;
    }

    @Override
    public String toString() {
        return "FarmerInfo{" +
                "memberNo=" + memberNo +
                ", farmerName='" + farmerName + '\'' +
                ", representativeName='" + representativeName + '\'' +
                ", representativeEmail='" + representativeEmail + '\'' +
                '}';
    }
}
