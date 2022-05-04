package com.greedy.dduckleaf.funding.entity;

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
@Entity(name = "ProjectShippingInfoForFundingRegsit")
@Table(name = "TBL_PROJECT_SHIPPING_INFO")
public class ProjectShippingInfo {

    @Id
    @Column(name = "PROJECT_NO")
    private int projectdNo;

    @Column(name = "SHIPPING_DUE_DATE")
    private String shippingDueDate;
}
