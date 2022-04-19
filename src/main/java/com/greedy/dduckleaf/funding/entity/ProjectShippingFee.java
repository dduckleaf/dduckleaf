package com.greedy.dduckleaf.funding.entity;

import javax.persistence.*;

@Entity(name = "ProjectShippingFeeForFunding")
@Table(name = "TBL_PROJECT_SHIPPING_FEE")
public class ProjectShippingFee {

    @Id
    @Column(name = "SHIPPING_FEE_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shppingFeeNo;


    @Column(name = "SHIPPING_FEE")
    private int shippingFee;

    @Column(name = "EXTRA_SHIPPING_FEE")
    private int extraShippingFee;


    @Column(name = "EXTRA_SHIPPING_FEE_INFO")
    private String extraShippingFeeInfo;


    @Column(name = "PROJECT_NO")
    private int projectNo;

}
