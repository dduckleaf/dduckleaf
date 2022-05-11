package com.greedy.dduckleaf.funding.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "MemberForAdminFindFunding")
@Table(name = "TBL_MEMBER")
public class MemberForAdmin {

    @Id
    @Column(name = "MEMBER_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberNo;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @Column(name = "MEMBER_ID")
    private String memberId;

    @Column(name = "MEMBER_PWD")
    private String memberPwd;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "MEMBER_ROLE")
    private int memberRole;

    @Column(name = "WITHDRAWAL_STATUS")
    private String whthdrawalStatus;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MEMBER_NO")
    private FarmerInfo farmer;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MEMBER_NO")
    private List<FundingForAdmin> fundings;
}
