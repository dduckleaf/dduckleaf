package com.greedy.dduckleaf.funding.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectShippingFeeDTO {
    private int shppingFeeNo;
    private int shippingFee;
    private int extraShippingFee;
    private String extraShippingFeeInfo;
    private int projectNo;

}
