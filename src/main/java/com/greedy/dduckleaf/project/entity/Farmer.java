package com.greedy.dduckleaf.project.entity;

import lombok.*;

import javax.persistence.*;

/**
 * <pre>
 * Class : Farmer
 * Comment :
 *
 * History
 * 2022-04-27 username
 * </pre>
 *
 * @author username
 * @version 1.0.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "FarmerForProjectDetail")
@Table(name = "TBL_FARMER_INFO")
public class Farmer {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "FARMER_NAME")
    private String farmerName;

    @Column(name = "BUSINESS_NAME")
    private String businessName;
}
