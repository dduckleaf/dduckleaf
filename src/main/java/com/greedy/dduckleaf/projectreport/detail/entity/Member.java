package com.greedy.dduckleaf.projectreport.detail.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "MemberForProjectReportDetail")
@Table(name = "TBL_MEMBER")
public class Member {

    @Id
    @Column(name = "MEMBER_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberNo;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @Transient
    @Column(name = "MEMBER_ID")
    private String memberId;

    @Transient
    @Column(name = "MEMBER_PWD")
    private String memberPwd;

    @Transient
    @Column(name = "EMAIL")
    private String email;

    @Transient
    @Column(name = "PHONE")
    private String phone;

    @Column(name = "MEMBER_ROLE")
    private int memberRole;

    @Transient
    @Column(name = "WITHDRAWAL_STATUS")
    private String withdrawalStatus;

    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", memberName='" + memberName + '\'' +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", memberRole=" + memberRole +
                ", withdrawalStatus='" + withdrawalStatus + '\'' +
                '}';
    }
}
