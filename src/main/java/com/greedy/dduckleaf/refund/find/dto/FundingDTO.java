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
public class FundingDTO {

    private int fundingInfoNo;
    private String fundingDate;
    private int fundingAmount;
    private int rewardAmount;
    private String fundingStatus;
    private int donateAmount;
    private String refundName;
    private int projectNo;
    private int memberNo;
    private String extraShippingFeeStatus;
    private int refundAccount;
}
