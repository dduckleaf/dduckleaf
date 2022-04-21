package com.greedy.dduckleaf.projectnotice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
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

}
