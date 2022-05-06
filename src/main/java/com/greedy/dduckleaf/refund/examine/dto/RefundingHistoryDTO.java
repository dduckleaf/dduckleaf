package com.greedy.dduckleaf.refund.examine.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RefundingHistoryDTO {

    private int refundingHisotryNo;
    private String managerType;
    private String refundingHistoryDate;
    private int refundingStatusNo;
    private String hitoryCategory;
    private int refundingAmount;
    private String refundingRefuseReason;
    private String refundingHistoryCategory;
    private int refundingInfoNo;
    private int refundingObjectionNo;
    private int refundingMemberNo;
}
