package com.greedy.dduckleaf.refund.find.dto;

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
public class RefundingStatusDTO {

    private int refundingStatusNo;
    private String refundingStatusName;
}
