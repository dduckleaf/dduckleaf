package com.greedy.dduckleaf.member.entity;

import javax.persistence.*;

@Entity(name = "FarmerInfoForMember")
@Table(name = "TBL_FARMER_INFO")
public class Farmer {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    public Farmer() {
    }

    public Farmer(int memberNo) {
        this.memberNo = memberNo;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "memberNo=" + memberNo +
                '}';
    }
}
