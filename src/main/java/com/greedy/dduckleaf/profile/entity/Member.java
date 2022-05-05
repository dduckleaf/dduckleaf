package com.greedy.dduckleaf.profile.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "MemberForProfileAttachment")
@Table(name = "TBL_MEMBER")
public class Member {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @Column(name = "MEMBER_PWD")
    private String memberPwd;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;
}
