package com.greedy.dduckleaf.refund.examine.dto;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RefundingObjectionDTO {

    private int refundObjectionNo;
    private String refundObjectionReason;
    private int refundingInfoNo;
    private int refundObjectionMemberNo;
}
