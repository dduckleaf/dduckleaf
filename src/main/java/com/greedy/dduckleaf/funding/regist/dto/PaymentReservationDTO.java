package com.greedy.dduckleaf.funding.regist.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PaymentReservationDTO {
    private int paymentReservationNo;
    private int fundingTotalAmount;
    private java.sql.Date paymentDueDate;
    private int fundingInfoNo;
    private int memberNo;
    private int projectNo;



}
