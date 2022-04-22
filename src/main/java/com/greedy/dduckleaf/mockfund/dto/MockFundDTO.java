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
    private java.util.Date openDate;
    private java.util.Date endDate;
    private String mockFundStatus;
    private java.util.Date canceledDate;
    private int targetTicketAmount;
    private String mockFundProgressStatus;
    private String examineResult;
    private int farmerNo;

}
