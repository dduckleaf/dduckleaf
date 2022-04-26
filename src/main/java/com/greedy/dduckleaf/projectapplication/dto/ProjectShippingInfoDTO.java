package com.greedy.dduckleaf.projectapplication.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectShippingInfoDTO {

    private int projectShippingInfoNo;
    private int shippingFee;
    private java.sql.Date shippingDueDate;
    private int projectNo;
    private int extraShippingFee;

}