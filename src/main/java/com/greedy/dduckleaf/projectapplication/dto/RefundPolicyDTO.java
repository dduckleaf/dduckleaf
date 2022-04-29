package com.greedy.dduckleaf.projectapplication.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RefundPolicyDTO {

    private int refundPolicyNo;
    private String refundPolicyCategory;    //추후 삭제 예정 컬럼
    private String refundPolicyContent;
    private int projectNo;
    private String refundPolicyAgreementStatus;

}
