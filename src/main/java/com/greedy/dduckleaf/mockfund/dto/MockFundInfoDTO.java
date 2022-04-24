package com.greedy.dduckleaf.mockfund.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MockFundInfoDTO {

    private int mockFundInfoNo;
    private String mockFundName;
    private java.sql.Date endDate;
    private String mockFundDetail;
    private int targetTicketAmount;
    private MockFundDTO mockFund;
    private RewardCategoryDTO rewardCategory;

}
