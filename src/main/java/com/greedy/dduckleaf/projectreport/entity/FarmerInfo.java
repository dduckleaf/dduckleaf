package com.greedy.dduckleaf.projectreport.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "FarmerInfoForProjectReport")
@Table(name = "TBL_FARMER_INFO")
public class FarmerInfo {

//    MEMBER_NO
    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

//    FARMER_NAME
    @Column(name = "FARMER_NAME")
    private String farmerName;

//            FARMER_EMAIL
    @Column(name = "FARMER_EMAIL")
    private String farmerEmail;

//    FARMER_PHONE
    @Column(name = "FARMER_PHONE")
    private String farmerPhone;

//            BUSINESS_OWN_TYPE
    @Column(name = "BUSINESS_OWN_TYPE")
    private String businessOwnType;

//    BUSINESS_OWN_NO
    @Column(name = "BUSINESS_OWN_NO")
    private int businessOwnNo;

//            BUSINESS_NAME
    @Column(name = "BUSINESS_NAME")
    private String businessName;

//    REPRESENTATIVE_NAME
    @Column(name = "REPRESENTATIVE_NAME")
    private String representativeName;

//            REPRESENTATIVE_EMAIL
    @Column(name = "REPRESENTATIVE_EMAIL")
    private String representativeEmail;

    public FarmerInfo() {}

    public FarmerInfo(int memberNo, String farmerName, String farmerEmail, String farmerPhone, String businessOwnType,
                      int businessOwnNo, String businessName, String representativeName, String representativeEmail) {
        this.memberNo = memberNo;
        this.farmerName = farmerName;
        this.farmerEmail = farmerEmail;
        this.farmerPhone = farmerPhone;
        this.businessOwnType = businessOwnType;
        this.businessOwnNo = businessOwnNo;
        this.businessName = businessName;
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

    public String getFarmerEmail() {
        return farmerEmail;
    }

    public void setFarmerEmail(String farmerEmail) {
        this.farmerEmail = farmerEmail;
    }

    public String getFarmerPhone() {
        return farmerPhone;
    }

    public void setFarmerPhone(String farmerPhone) {
        this.farmerPhone = farmerPhone;
    }

    public String getBusinessOwnType() {
        return businessOwnType;
    }

    public void setBusinessOwnType(String businessOwnType) {
        this.businessOwnType = businessOwnType;
    }

    public int getBusinessOwnNo() {
        return businessOwnNo;
    }

    public void setBusinessOwnNo(int businessOwnNo) {
        this.businessOwnNo = businessOwnNo;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
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
                ", farmerEmail='" + farmerEmail + '\'' +
                ", farmerPhone='" + farmerPhone + '\'' +
                ", businessOwnType='" + businessOwnType + '\'' +
                ", businessOwnNo=" + businessOwnNo +
                ", businessName='" + businessName + '\'' +
                ", representativeName='" + representativeName + '\'' +
                ", representativeEmail='" + representativeEmail + '\'' +
                '}';
    }
}
