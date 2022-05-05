package com.greedy.dduckleaf.projectreport.find.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "FarmerInfoForProjectReport")
@Table(name = "TBL_FARMER_INFO")
public class FarmerInfo {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "FARMER_NAME")
    private String farmerName;

    @Override
    public String toString() {
        return "FarmerInfo{" +
                "memberNo=" + memberNo +
                ", farmerName='" + farmerName + '\'' +
                '}';
    }
}
