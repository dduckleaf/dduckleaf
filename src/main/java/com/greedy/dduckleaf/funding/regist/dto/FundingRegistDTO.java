package com.greedy.dduckleaf.funding.regist.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class FundingRegistDTO {
    private int totalFunding;       //
    private int rewardTotal;         //
    private int rewardPrice;        //
    private int rewardAmount;       //
    private int donate;             //
    private int shippingFee;        //
    private int extraShippingFee;   //
    private int projectNo;

    private ShippingAddressDTO shippingAddress;
    private RefundAccountDTO refundAccountInfo;
}



