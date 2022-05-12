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
public class RefundObjectionHistoryDTO {

    private int refundObjectionHistoryNo;
    private int refundInfoNo;
    private String historyDate;
    private String historyCategory;
    private String refuseReason;
    private int refundObjectionNo;
}
