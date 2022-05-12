package com.greedy.dduckleaf.settlement.dto;

public class FarmerInfoDTO {

    private int memberNo;                               //회원번호
    private String farmerName;                             //상호명
    private String farmerEmail;                            //문의 이메일
    private String farmerPhone;                         //문의 전화번호
    private String businessOwnType;                   //사업자유형
    private int businessOwnNo;                        //사업자 등록번호
    private String businessName;                      //상호명
    private String representativeName;                  //대표자명
    private String representativeEmail;               //대표자이메일
    private String representativeSsn;                 //대표자 주민등록번호
    private String corporateName;                     //법인명
    private String corporationType;                   //법인사업자유형
    private String taxType;                           //과세유형
    private String taxTypeCategory;                   //구분
    private int corporateLicenseNo;                   //법인등록번호

    public FarmerInfoDTO() {}

    public FarmerInfoDTO(int memberNo, String farmerName, String farmerEmail, String farmerPhone, String businessOwnType,
                         int businessOwnNo, String businessName, String representativeName, String representativeEmail,
                         String representativeSsn, String corporateName, String corporationType, String taxType,
                         String taxTypeCategory, int corporateLicenseNo) {
        this.memberNo = memberNo;
        this.farmerName = farmerName;
        this.farmerEmail = farmerEmail;
        this.farmerPhone = farmerPhone;
        this.businessOwnType = businessOwnType;
        this.businessOwnNo = businessOwnNo;
        this.businessName = businessName;
        this.representativeName = representativeName;
        this.representativeEmail = representativeEmail;
        this.representativeSsn = representativeSsn;
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

    public String getRepresentativeSsn() {
        return representativeSsn;
    }

    public void setRepresentativeSsn(String representativeSsn) {
        this.representativeSsn = representativeSsn;
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
                ", farmerName=" + farmerName +
                ", farmerEmail=" + farmerEmail +
                ", farmerPhone='" + farmerPhone + '\'' +
                ", businessOwnType='" + businessOwnType + '\'' +
                ", businessOwnNo=" + businessOwnNo +
                ", businessName='" + businessName + '\'' +
                ", representativeName='" + representativeName + '\'' +
                ", representativeEmail='" + representativeEmail + '\'' +
                ", representativeSsn='" + representativeSsn + '\'' +
                ", corporateName='" + corporateName + '\'' +
                ", corporationType='" + corporationType + '\'' +
                ", taxType='" + taxType + '\'' +
                ", taxTypeCategory='" + taxTypeCategory + '\'' +
                ", corporateLicenseNo=" + corporateLicenseNo +
                '}';
    }
}
