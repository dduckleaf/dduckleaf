package com.greedy.dduckleaf.projectapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "FarmerInfoForProjectApplication")
@Table(name = "TBL_FARMER_INFO")
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
    private int corporateLicenseNo;         //법인등록번호

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
