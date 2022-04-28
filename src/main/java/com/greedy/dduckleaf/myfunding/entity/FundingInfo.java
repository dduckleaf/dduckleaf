package com.greedy.dduckleaf.myfunding.entity;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "FundingInfoForMyFunding")
@Table(name = "TBL_FUNDING_INFO")
public class FundingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FUNDING_INFO_NO")
    private int fundingInfoNo;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "MEMBER_NO")
    private Member member;
//
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PROJECT_NO")
    private Project project;

}
