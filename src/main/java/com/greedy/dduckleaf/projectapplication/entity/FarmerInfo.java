package com.greedy.dduckleaf.projectapplication.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity(name = "FarmerInfoForProjectApplication")
@Table(name = "TBL_FARMER_INFO")
@DynamicInsert
public class FarmerInfo {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "FARMER_NAME")
    private String farmerName;

    @Column(name = "FARMER_EMAIL")
    private String farmerEmail;

    @Column(name = "FARMER_PHONE")
    private String farmerPhone;

    @Column(name = "BUSINESS_OWN_TYPE")
    private String businessOwnType;         //사업자 유형

    @Column(name = "BUSINESS_OWN_NO")
    private String businessOwnNo;           //사업자 등록번호

    @Column(name = "BUSINESS_NAME")
    private String businessName;            //상호명

    @Column(name = "REPRESENTATIVE_NAME")
    private String representativeName;      //대표자명

    @Column(name = "REPRESENTATIVE_EMAIL")
    private String representativeEmail;     //대표자이메일

    @Column(name = "REPRESENTATIVE_SSN")
    private String representativeSSN;       //대표자 주민등록번호

    @Column(name = "CORPORATE_NAME")
    private String corporateName;           //법인명

    @Column(name = "CORPORATION_TYPE")
    private String corporationType;         //법인사업자유형

    @Column(name = "TAX_TYPE")
    private String taxType;                 //과세유형

    @Column(name = "TAX_TYPE_CATEGORY")
    private String taxTypeCategory;         //구분

    @Column(name = "CORPORATE_LICENSE_NO")
    private Integer corporateLicenseNo;         //법인등록번호

    @Column(name = "KAKAOTALK_CHANNEL")
    private String kakaotTalkChannel;

    @Column(name = "HOMEPAGE_URL")
    private String homepageURL;

    public FarmerInfo() {
    }

    public FarmerInfo(int memberNo, String farmerName, String farmerEmail, String farmerPhone, String businessOwnType, String businessOwnNo, String businessName, String representativeName, String representativeEmail, String representativeSSN, String corporateName, String corporationType, String taxType, String taxTypeCategory, Integer corporateLicenseNo, String kakaotTalkChannel, String homepageURL) {
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

    public Integer getCorporateLicenseNo() {
        return corporateLicenseNo;
    }

    public void setCorporateLicenseNo(Integer corporateLicenseNo) {
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
                ", kakaotTalkChannel='" + kakaotTalkChannel + '\'' +
                ", homepageURL='" + homepageURL + '\'' +
                '}';
    }

}
