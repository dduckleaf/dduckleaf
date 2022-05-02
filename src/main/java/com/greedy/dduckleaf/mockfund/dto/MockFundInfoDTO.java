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
    private String endDate;
    private String mockFundDetail;
    private int targetTicketAmount;
    private String mockFundAgreementStatus;
    private String agreementDate;
    private MockFundDTO mockFund;
    private RewardCategoryDTO rewardCategory;

}
