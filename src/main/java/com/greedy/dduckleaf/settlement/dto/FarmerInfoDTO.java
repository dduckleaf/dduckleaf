package com.greedy.dduckleaf.settlement.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FarmerInfoDTO {

    private int memberNo;                               //회원번호
    private int farmerName;                             //상호명
    private int farmerEmail;                            //문의 이메일
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
