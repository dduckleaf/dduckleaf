package com.greedy.dduckleaf.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "FarmerForMain")
@Table(name = "TBL_FARMER_INFO")
public class Farmer {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "BUSINESS_NAME")
    private String businessName;
}
