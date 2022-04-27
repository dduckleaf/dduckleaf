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
    private java.sql.Date openDate;
    private java.sql.Date endDate;
    private String mockFundStatus;
    private java.sql.Date canceledDate;
    private int targetTicketAmount;
    private String mockFundProgressStatus;
    private String examineResult;
    private FarmerDTO farmerNo;

}
