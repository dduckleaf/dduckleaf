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
/**
 * <pre>
 * Class : FarmerInfo
 * Comment :
 *
 * History
 * 2022-05-01 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
@Entity(name = "FarmerInfoForFundingRegist")
@Table(name = "TBL_FARMER_INFO")
public class FarmerInfo {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "BUSINESS_NAME")
    private String businessName;

    @Column(name = "FARMER_NAME")
    private String farmerName;
}
