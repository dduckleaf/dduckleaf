package com.greedy.dduckleaf.member.entity;

import javax.persistence.*;

@Entity(name = "Member")
@Table(name = "TBL_MEMBER")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_NO")
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

    @OneToOne
    @JoinColumn(name = "MEMBER_ROLE")
    private MemberCategory memberCategory;

    @Column(name = "WITHDRAWAL_STATUS")
    private String withdrawalStatus;

    @Column(name = "MEMBER_JOIN_DATE")
    private String memberJoinDate;

    public Member() {
    }

    public Member(int memberNo, String memberName, String memberId, String memberPwd, String email, String phone, MemberCategory memberCategory, String withdrawalStatus, String memberJoinDate) {
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.email = email;
        this.phone = phone;
        this.memberCategory = memberCategory;
        this.withdrawalStatus = withdrawalStatus;
        this.memberJoinDate = memberJoinDate;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public MemberCategory getMemberCategory() {
        return memberCategory;
    }

    public void setMemberCategory(MemberCategory memberCategory) {
        this.memberCategory = memberCategory;
    }

    public String getWithdrawalStatus() {
        return withdrawalStatus;
    }

    public void setWithdrawalStatus(String withdrawalStatus) {
        this.withdrawalStatus = withdrawalStatus;
    }

    public String getMemberJoinDate() {
        return memberJoinDate;
    }

    public void setMemberJoinDate(String memberJoinDate) {
        this.memberJoinDate = memberJoinDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", memberName='" + memberName + '\'' +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", memberCategory=" + memberCategory +
                ", withdrawalStatus='" + withdrawalStatus + '\'' +
                ", memberJoinDate='" + memberJoinDate + '\'' +
                '}';
    }
}
