package com.greedy.dduckleaf.refund.examine.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RefundingDTO {

    private int refundingInfoNo;
    private String refundingDate;
    private RefundingCategoryDTO refundingCategory;
    private String refundingReason;
    private RefundingStatusDTO refundingStatus;
    private ProjectDTO project;
    private String refundingAccount;
    private int bankNo;
    private String refundingMemberName;
    private int memberNo;
    private FundingDTO funding;
}
