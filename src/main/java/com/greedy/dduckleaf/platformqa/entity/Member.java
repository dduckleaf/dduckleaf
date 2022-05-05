package com.greedy.dduckleaf.platformqa.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "MemberForPlatformQa")
@Table(name = "TBL_MEMBER")
public class Member {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @Column(name = "MEMBER_ID")
    private String memberId;

    @Column(name = "MEMBER_ROLE")
    private int memberRole;
}
