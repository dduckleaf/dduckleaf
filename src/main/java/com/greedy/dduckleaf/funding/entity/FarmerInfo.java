package com.greedy.dduckleaf.funding.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 * Class : FarmerInfo
 * Comment :
 *
 * History
 * 2022-05-01 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
@Entity(name = "FarmerInfoForFundingRegist")
@Table(name = "TBL_FARMER_INFO")
public class FarmerInfo {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "BUSINESS_NAME")
    private String businessName;

    public FarmerInfo() {
    }

    public FarmerInfo(int memberNo, String businessName) {
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
        return "FarmerInfo{" +
                "memberNo=" + memberNo +
                ", businessName='" + businessName + '\'' +
                '}';
    }
}
