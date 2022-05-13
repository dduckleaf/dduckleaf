package com.greedy.dduckleaf.funding.dto;

import lombok.*;

import javax.persistence.Column;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class FundingDTO {
    private int fundingInfoNo;
    private String fundingDate;
    private int fundingAmount;
    private int rewardAmount;
    private String fundingStatus;
    private int donateAmount;
    private int projectNo;
    private int shippingFeeNo;
    private int memberNo;
    private String rewardCategoryName;
    private String extraShippingFeeStatus;
    private BankDTO refundBankCode;
    private int refundAccount;
    private String refundName;
    private ProjectDTO project;

    private RefundAccountDTO refundAccountInfo;

}
