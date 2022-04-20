package com.greedy.dduckleaf.funding.regist.entity;

import javax.persistence.*;

@Entity(name = "MemberForFunding")
@Table(name = "TBL_MEMBER")
public class Member {
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

}
