package com.greedy.dduckleaf.refund.regist.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "MemberForRefundingRegist")
@Table(name = "TBL_MEMBER")
public class Member {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "MEMBER_NAME")
    private String memberName;
}
