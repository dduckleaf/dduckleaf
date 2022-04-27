package com.greedy.dduckleaf.projectapplication.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectApplicationInfoDTO {                        //프로젝트 신청 내역

    private int projectApplicationNo;
    private String projectApplicationCategory;                  //구분
    private ProjectBasicInfoDTO projectBasicInfoNo;             //기본 정보 번호
    private ProjectShippingInfoDTO projectShippingInfoNo;       //발송 정보 번호
    private RewardRegistInfoDTO rewardRegistInfoNo;             //리워드 등록 정보 번호
    private RefundPolicyDTO refundPolicyNo;                     //환불 정책 번호
    private ProjectDTO projectNo;
    private FarmerInfoDTO memberNo;
    private FarmerFinancialInfoDTO farmerFinancialInfoDTO;

}
