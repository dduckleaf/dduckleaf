package com.greedy.dduckleaf.funding.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "FundingForAdmin")
@Table(name = "TBL_FUNDING_INFO")
public class FundingForAdmin {

    @Id
    @Column(name = "FUNDING_INFO_NO")
    private int fundingInfoNo;

    @Column(name = "FUNDING_DATE")
    private String fundingDate;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "FUNDING_INFO_NO")
    private List<Refunding> refundings;
}