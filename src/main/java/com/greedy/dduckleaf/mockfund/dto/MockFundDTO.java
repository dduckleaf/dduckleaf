package com.greedy.dduckleaf.mockfund.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MockFundDTO {

    private int mockFundNo;
    private String mockFundName;
    private String openDate;
    private String endDate;
    private String mockFundStatus;
    private String canceledDate;
    private int targetTicketAmount;
    private String mockFundProgressStatus;
    private String examineResult;
    private FarmerDTO farmer;

}
