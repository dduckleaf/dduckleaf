package com.greedy.dduckleaf.member.entity;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "MemberWithdrawForMember")
@Table(name = "TBL_MEMBER_WITHDRAW")
public class MemberWithdraw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WITHDRAW_NO")
    private int withdrawNo;

    @Column(name = "WITHDRAW_REASON")
    private String withdrawReason;

    @Column(name = "WITHDRAW_DATE")
    private String withdrawDate;

    @Column(name = "MEMBER_NO")
    private int memberNo;
}
