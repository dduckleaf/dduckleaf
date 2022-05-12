package com.greedy.dduckleaf.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "FarmerForMain")
@Table(name = "TBL_FARMER_INFO")
public class Farmer {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "BUSINESS_NAME")
    private String businessName;

    public Farmer() {
    }

    public Farmer(int memberNo, String businessName) {
        this.memberNo = memberNo;
        this.businessName = businessName;
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
        return "Farmer{" +
                "memberNo=" + memberNo +
                ", businessName='" + businessName + '\'' +
                '}';
    }
}
