package com.greedy.dduckleaf.funding.entity;

import javax.persistence.*;

@Entity(name = "ShippingAddressForFunding")
@Table(name = "TBL_SHIPPING_ADDRESS")
public class ShippingAddress {

    @Id
    @Column(name = "SHIPPING_ADDRESS_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shippingAddressNo;

    @Column(name = "SHIPPING_ADDRESS")
    private String shippingAddress;

    @Column(name = "FUNDING_INFO_NO")
    private int fundingInfoNo;

    @Column(name = "MEMBER_NO")
    private int memberNo;
}
