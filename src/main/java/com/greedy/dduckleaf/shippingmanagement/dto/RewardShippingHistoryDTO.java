package com.greedy.dduckleaf.shippingmanagement.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RewardShippingHistoryDTO {

    private int rewardShippingHistoryNo;
    private int shippingStatus;
    private int rewardShippingNo;
    private String shipDate;
    private String deliveredDate;
}
