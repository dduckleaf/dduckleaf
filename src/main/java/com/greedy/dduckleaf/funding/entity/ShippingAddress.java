package com.greedy.dduckleaf.funding.entity;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "ShippingAddressForFunding")
@Table(name = "TBL_SHIPPING_ADDRESS")
public class ShippingAddress {
    @Id
    @Column(name = "SHIPPING_ADDRESS_NO")
    private int shippingAddresNo;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "FUNDING_INFO_NO")
    private Funding funding;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "SHIPPING_ADDRESS")
    private String shippingAddress;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @Column(name = "MEMBER_PHONE")
    private String memberPhone;

    @Column(name = "SHIPPING_REQUIRE")
    private String shippingRequire;
}
