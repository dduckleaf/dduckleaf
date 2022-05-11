package com.greedy.dduckleaf.refund.find.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RefundingForAdminListDTO {

    private int refundingInfoNo;
    private int projectNo;
    private String projectName;
    private String farmerName;
    private String refundStatus;
    private String refundingDate;
    private String refundingEndDate;

}
