package com.greedy.dduckleaf.mockfund.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MockFundRewardDTO {

    private int mockFundRewardNo;
    private String rewardName;
    private String rewardDetail;
    private int rewardPrice;
    private MockFundDTO mockFund;

}
