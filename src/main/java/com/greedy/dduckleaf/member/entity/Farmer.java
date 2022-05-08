package com.greedy.dduckleaf.member.entity;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "FarmerInfoForMember")
@Table(name = "TBL_FARMER_INFO")
public class Farmer {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;
}
