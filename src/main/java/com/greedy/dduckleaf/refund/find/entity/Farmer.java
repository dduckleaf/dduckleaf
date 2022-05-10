package com.greedy.dduckleaf.refund.find.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "FarmerForRefundingAdminProjectList")
@Table(name = "TBL_FARMER_INFO")
public class Farmer {


    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "FARMER_NAME")
    private String farmerName;


    @Column(name = "BUSINESS_NAME")
    private String businessName;

    @Override
    public String toString() {
        return "Farmer{" +
                ", memberNo=" + memberNo +
                ", businessName='" + businessName + '\'' +
                '}';
    }
}
