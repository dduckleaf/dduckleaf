package com.greedy.dduckleaf.refund.regist.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RefundingDTO {

    private int refundingInfoNo;
    private String refundingDate;
    private int refundingCategoryNo;
    private String refundingReason;
    private int refundingStatusNo;
    private int projectNo;
    private String refundingAccount;
    private int bankNo;
    private String refundingMemberName;
    private int memberNo;
    private int fundingInfoNo;
}
