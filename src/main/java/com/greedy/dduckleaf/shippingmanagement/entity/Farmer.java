package com.greedy.dduckleaf.shippingmanagement.entity;

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
@Entity(name = "FarmerForShipping")
@Table(name = "TBL_FARMER_INFO")
public class Farmer {

    @Column(name = "FARMER_NO")
    private int farmerNo;

    @Column(name = "FARMER_NAME")
    private String farmerName;

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "BUSINESS_NAME")
    private String businessName;
}
