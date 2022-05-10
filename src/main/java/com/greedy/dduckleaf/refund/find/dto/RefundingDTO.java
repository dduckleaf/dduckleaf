package com.greedy.dduckleaf.refund.find.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private String refundingEndDate;
}
