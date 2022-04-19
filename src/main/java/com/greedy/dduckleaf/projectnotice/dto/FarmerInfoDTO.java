package com.greedy.dduckleaf.projectnotice.dto;

public class FarmerInfoDTO {

    private String farmerName;
    private String farmerEmail;
    private String farmerPhone;
    private String businessOwnType;
    private String businessOwnNo;
    private String businessName;
    private String representativeName;
    private String representativeEmail;
    private String representativeSSN;
    private String corporateName;
    private String corporationType;
    private String taxType;
    private String taxTypeCategory;
    private int corporateLicenseNo;
    private int memberNo;

    public FarmerInfoDTO() {}

    public FarmerInfoDTO(String farmerName, String farmerEmail, String farmerPhone, String businessOwnType, String businessOwnNo, String businessName, String representativeName, String representativeEmail, String representativeSSN, String corporateName, String corporationType, String taxType, String taxTypeCategory, int corporateLicenseNo, int memberNo) {
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

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    @Override
    public String toString() {
        return "FarmerInfoDTO{" +
                "farmerName='" + farmerName + '\'' +
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
                ", memberNo=" + memberNo +
                '}';
    }
}
