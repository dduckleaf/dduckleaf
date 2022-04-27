package com.greedy.dduckleaf.projectapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "FarmerInfoForProjectApplication")
@Table(name = "TBL_FARMER_INFO")
@DynamicInsert
public class FarmerInfo {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "FARMER_NAME")
//    @ColumnDefault("파머 이름")
    private String farmerName;

    @Column(name = "FARMER_EMAIL")
//    @ColumnDefault("이메일")
    private String farmerEmail;

    @Column(name = "FARMER_PHONE")
//    @ColumnDefault("전화번호")
    private String farmerPhone;

    @Column(name = "BUSINESS_OWN_TYPE")
    private String businessOwnType;         //사업자 유형

    @Column(name = "BUSINESS_OWN_NO")
//    @ColumnDefault("사업자 등록번호")
    private String businessOwnNo;           //사업자 등록번호

    @Column(name = "BUSINESS_NAME")
//    @ColumnDefault("상호명")
    private String businessName;            //상호명

    @Column(name = "REPRESENTATIVE_NAME")
//    @ColumnDefault("대표자명")
    private String representativeName;      //대표자명

    @Column(name = "REPRESENTATIVE_EMAIL")
//    @ColumnDefault("대표자이메일")
    private String representativeEmail;     //대표자이메일

    @Column(name = "REPRESENTATIVE_SSN")
//    @ColumnDefault("주민등록번호")
    private String representativeSSN;       //대표자 주민등록번호

    @Column(name = "CORPORATE_NAME")
//    @ColumnDefault("법인명")
    private String corporateName;           //법인명

    @Column(name = "CORPORATION_TYPE")
    private String corporationType;         //법인사업자유형

    @Column(name = "TAX_TYPE")
    private String taxType;                 //과세유형

    @Column(name = "TAX_TYPE_CATEGORY")
    private String taxTypeCategory;         //구분

    @Column(name = "CORPORATE_LICENSE_NO")
//    @ColumnDefault("")
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

    @PrePersist
    public void prePersist() {

        this.farmerName = this.farmerName  == null ? "파머이름" : this.farmerName ;
        this.farmerEmail = this.farmerEmail  == null ? "이메일" : this.farmerEmail ;
        this.farmerPhone = this.farmerPhone  == null ? "전화번호" : this.farmerPhone ;
        this.businessOwnNo = this.businessOwnNo  == null ? "사업자등록번호" : this.businessOwnNo ;
        this.businessName = this.businessName  == null ? "상호명" : this.businessName ;
        this.representativeName = this.representativeName  == null ? "대표자명" : this.representativeName ;
        this.representativeEmail = this.representativeEmail  == null ? "대표자이메일" : this.representativeEmail ;
        this.representativeSSN = this.representativeSSN  == null ? "주민등록번호" : this.representativeSSN ;
        this.corporateName = this.corporateName  == null ? "법인명" : this.corporateName ;
        this.businessOwnType = this.businessOwnType  == null ? "사업자유형" : this.businessOwnType ;

    }
}
