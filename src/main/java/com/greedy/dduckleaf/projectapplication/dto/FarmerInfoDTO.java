package com.greedy.dduckleaf.projectapplication.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
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

}
