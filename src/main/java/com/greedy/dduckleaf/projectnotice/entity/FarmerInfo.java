package com.greedy.dduckleaf.projectnotice.entity;

import javax.persistence.*;

@Entity(name = "FarmerInfo")
@Table(name = "TBL_FARMER_INFO")
public class FarmerInfo {

    @Id
    @JoinColumn(name = "FARMER_NO")
    private int memberNo;

    @Column(name = "FARMER_NAME")
    private String farmerName;

    @Column(name = "FARMER_EMAIL")
    private String farmerEmail;

    @Column(name = "FARMER_PHONE")
    private String farmerPhone;

    @Column(name = "BUSINESS_OWN_TYPE")
    private String businessOwnType;

    @Column(name = "BUSINESS_OWN_NO")
    private String businessOwnNo;

    @Column(name = "BUSINESS_NAME")
    private String businessName;

    @Column(name = "REPRESENTATIVE_NAME")
    private String representativeName;

    @Column(name = "REPRESENTATIVE_EMAIL")
    private String representativeEmail;

    @Column(name = "REPRESENTATIVE_SSN")
    private String representativeSSN;

    @Column(name = "CORPORATE_NAME")
    private String corporateName;

    @Column(name = "CORPORATION_TYPE")
    private String corporationType;

    @Column(name = "TAX_TYPE")
    private String taxType;

    @Column(name = "TAX_TYPE_CATEGORY")
    private String taxTypeCategory;

    @Column(name = "CORPORATE_LICENSE_NO")
    private int corporateLicenseNo;

    public FarmerInfo() {}

    public FarmerInfo(int memberNo, String farmerName, String farmerEmail, String farmerPhone, String businessOwnType, String businessOwnNo, String businessName, String representativeName, String representativeEmail, String representativeSSN, String corporateName, String corporationType, String taxType, String taxTypeCategory, int corporateLicenseNo) {
        this.memberNo = memberNo;
        this.farmerName = farmerName;
        this.farmerEmail = farmerEmail;
        this.farmerPhone = farmerPhone;
        this.businessOwnType = businessOwnType;
        this.businessOwnNo = businessOwnNo;
        this.businessName = businessName;
        this.representativeName = representativeName;
        this.representativeEmail = representativeEmail;
        this.representativeSSN = representativeSSN;
        this.corporateName = corporateName;
        this.corporationType = corporationType;
        this.taxType = taxType;
        this.taxTypeCategory = taxTypeCategory;
        this.corporateLicenseNo = corporateLicenseNo;
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

    public String getBusinessOwnNo() {
        return businessOwnNo;
    }

    public void setBusinessOwnNo(String businessOwnNo) {
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

    public String getRepresentativeSSN() {
        return representativeSSN;
    }

    public void setRepresentativeSSN(String representativeSSN) {
        this.representativeSSN = representativeSSN;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getCorporationType() {
        return corporationType;
    }

    public void setCorporationType(String corporationType) {
        this.corporationType = corporationType;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getTaxTypeCategory() {
        return taxTypeCategory;
    }

    public void setTaxTypeCategory(String taxTypeCategory) {
        this.taxTypeCategory = taxTypeCategory;
    }

    public int getCorporateLicenseNo() {
        return corporateLicenseNo;
    }

    public void setCorporateLicenseNo(int corporateLicenseNo) {
        this.corporateLicenseNo = corporateLicenseNo;
    }

    @Override
    public String toString() {
        return "FarmerInfo{" +
                "memberNo=" + memberNo +
                ", farmerName='" + farmerName + '\'' +
                ", farmerEmail='" + farmerEmail + '\'' +
                ", farmerPhone='" + farmerPhone + '\'' +
                ", businessOwnType='" + businessOwnType + '\'' +
                ", businessOwnNo='" + businessOwnNo + '\'' +
                ", businessName='" + businessName + '\'' +
                ", representativeName='" + representativeName + '\'' +
                ", representativeEmail='" + representativeEmail + '\'' +
                ", representativeSSN='" + representativeSSN + '\'' +
                ", corporateName='" + corporateName + '\'' +
                ", corporationType='" + corporationType + '\'' +
                ", taxType='" + taxType + '\'' +
                ", taxTypeCategory='" + taxTypeCategory + '\'' +
                ", corporateLicenseNo=" + corporateLicenseNo +
                '}';
    }
}
