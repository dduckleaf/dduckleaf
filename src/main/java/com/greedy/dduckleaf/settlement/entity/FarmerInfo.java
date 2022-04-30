package com.greedy.dduckleaf.settlement.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "FarmerInfoForSettlement")
@Table(name = "TBL_FARMER_INFO")
public class FarmerInfo {

    @Id
    @Column(name = "MEMBER_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberNo;                               //회원번호

    @Column(name = "FARMER_NAME")
    private int farmerName;                             //상호명

    @Column(name = "FARMER_EMAIL")
    private int farmerEmail;                            //문의 이메일

    @Column(name = "FARMER_PHONE")
    private String farmerPhone;                         //문의 전화번호

    @Transient
    @Column(name = "BUSINESS_OWN_TYPE")
    private String businessOwnType;                   //사업자유형

    @Transient
    @Column(name = "BUSINESS_OWN_NO")
    private int businessOwnNo;                        //사업자 등록번호

    @Transient
    @Column(name = "BUSINESS_NAME")
    private String businessName;                      //상호명

    @Column(name = "REPRESENTATIVE_NAME")
    private String representativeName;                  //대표자명

    @Column(name = "REPRESENTATIVE_EMAIL")
    private String representativeEmail;               //대표자이메일

    @Transient
    @Column(name = "REPRESENTATIVE_SSN")
    private String representativeSsn;                 //대표자 주민등록번호

    @Transient
    @Column(name = "CORPORATE_NAME")
    private String corporateName;                     //법인명

    @Transient
    @Column(name = "CORPORATION_TYPE")
    private String corporationType;                   //법인사업자유형

    @Transient
    @Column(name = "TAX_TYPE")
    private String taxType;                           //과세유형

    @Transient
    @Column(name = "TAX_TYPE_CATEGORY")
    private String taxTypeCategory;                   //구분

    @Transient
    @Column(name = "CORPORATE_LICENSE_NO")
    private int corporateLicenseNo;                   //법인등록번호

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
