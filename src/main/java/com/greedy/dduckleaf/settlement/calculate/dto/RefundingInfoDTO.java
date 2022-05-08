package com.greedy.dduckleaf.settlement.calculate.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RefundingInfoDTO {

    private int refundingInfoNo;
    private String refundingDate;
    private int refundingStatusNo;
    private int projectNo;
    private String refundingEndDate;
    private String projectEndDate;
    private int fundingInfoNo;
    private int fundingAmount;
    private int donateAmount;
}
