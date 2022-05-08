package com.greedy.dduckleaf.project.dto;

import com.greedy.dduckleaf.projectapplication.dto.ProjectDTO;
import com.greedy.dduckleaf.projectapplication.dto.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectApplicationInfoDTO {                        //프로젝트 신청 내역

    private int projectApplicationNo;
    private String projectApplicationCategory;                  //구분
    private ProjectBasicInfoDTO projectBasicInfo;             //기본 정보 번호
    private ProjectShippingInfoDTO projectShippingInfo;       //발송 정보 번호
    private RewardRegistInfoDTO rewardRegistInfo;             //리워드 등록 정보 번호
    private RefundPolicyDTO refundPolicy;                     //환불 정책 번호
    private ProjectDTO project;
    private FarmerInfoDTO farmer;

}
