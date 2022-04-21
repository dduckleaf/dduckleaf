package com.greedy.dduckleaf.funding.regist.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
/**
 * <pre>
 * Class : FundingRegistDTO
 * Comment :
 *
 * History
 * 2022-04-21 h99ww
 * </pre>
 *
 * @author h99ww
 * @version 1.0.0
 */
public class FundingRegistDTO {
    private int totalFunding;       //
    private int rewardTotal;         //
    private int rewardPrice;        //
    private int rewardAmount;       //
    private int donate;             //
    private int shippingFee;        //
    private int extraShippingFee;   //
    private int projectNo;
}



