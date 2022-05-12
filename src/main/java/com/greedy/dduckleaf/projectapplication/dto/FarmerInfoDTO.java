package com.greedy.dduckleaf.projectapplication.dto;

public class FarmerInfoDTO {

    private int memberNo;
    private String farmerName;
    private String farmerEmail;
    private String farmerPhone;
    private String businessOwnType;         //사업자 유형
    private String businessOwnNo;           //사업자 등록번호
    private String businessName;            //상호명
    private String representativeName;      //대표자명
    private String representativeEmail;     //대표자이메일
    private String representativeSSN;       //대표자 주민등록번호
    private String corporateName;           //법인명
    private String corporationType;         //법인사업자유형
    private String taxType;                 //과세유형
    private String taxTypeCategory;         //구분
    private int corporateLicenseNo;         //법인등록번호
    private String kakaotTalkChannel;
    private String homepageURL;

    public FarmerInfoDTO() {
    }

    public FarmerInfoDTO(int memberNo, String farmerName, String farmerEmail, String farmerPhone, String businessOwnType, String businessOwnNo, String businessName, String representativeName, String representativeEmail, String representativeSSN, String corporateName, String corporationType, String taxType, String taxTypeCategory, int corporateLicenseNo, String kakaotTalkChannel, String homepageURL) {
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
        this.kakaotTalkChannel = kakaotTalkChannel;
        this.homepageURL = homepageURL;
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

    public String getKakaotTalkChannel() {
        return kakaotTalkChannel;
    }

    public void setKakaotTalkChannel(String kakaotTalkChannel) {
        this.kakaotTalkChannel = kakaotTalkChannel;
    }

    public String getHomepageURL() {
        return homepageURL;
    }

    public void setHomepageURL(String homepageURL) {
        this.homepageURL = homepageURL;
    }

    @Override
    public String toString() {
        return "FarmerInfoDTO{" +
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
                ", kakaotTalkChannel='" + kakaotTalkChannel + '\'' +
                ", homepageURL='" + homepageURL + '\'' +
                '}';
    }
}
