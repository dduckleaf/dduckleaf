package com.greedy.dduckleaf.funding.dto;

import com.greedy.dduckleaf.funding.entity.Funding;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PaymentHistoryDTO {

    private int paymentHistoryNo;
    private int memberNo;
    private String paymentResultStauts;
    private String paymentResultDate;
    private Funding funding;
}
