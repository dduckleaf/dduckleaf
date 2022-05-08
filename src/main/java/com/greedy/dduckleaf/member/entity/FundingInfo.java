package com.greedy.dduckleaf.member.entity;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "FundingInfoForMember")
@Table(name = "TBL_FUNDING_INFO")
public class FundingInfo {

    @Id
    @Column(name = "FUNDING_INFO_NO")
    private int fundingInfoNo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MEMBER_NO")
    private Member member;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PROJECT_NO")
    private Project project;
}
