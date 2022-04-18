package com.greedy.dduckleaf.member.entity;

import javax.persistence.*;
import java.sql.Date;

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

    @Column(name = "MEMBER_ROLE")
    private String memberRole;

    @Column(name = "WITHDRAWAL_STATUS")
    private String withdrawalStatus;

    @Column(name = "WITHDRAWAL_DATE")
    private Date withdrawalDate;

    @Column(name = "WITHDRAWAL_REASON")
    private  String withdrawalReason;

    public Member() {
    }

    public Member(int memberNo, String memberName, String memberId, String memberPwd, String email, String phone, String memberRole, String withdrawalStatus, Date withdrawalDate, String withdrawalReason) {
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.email = email;
        this.phone = phone;
        this.memberRole = memberRole;
        this.withdrawalStatus = withdrawalStatus;
        this.withdrawalDate = withdrawalDate;
        this.withdrawalReason = withdrawalReason;
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

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public String getWithdrawalStatus() {
        return withdrawalStatus;
    }

    public void setWithdrawalStatus(String withdrawalStatus) {
        this.withdrawalStatus = withdrawalStatus;
    }

    public Date getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(Date withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public String getWithdrawalReason() {
        return withdrawalReason;
    }

    public void setWithdrawalReason(String withdrawalReason) {
        this.withdrawalReason = withdrawalReason;
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
                ", memberRole='" + memberRole + '\'' +
                ", withdrawalStatus='" + withdrawalStatus + '\'' +
                ", withdrawalDate=" + withdrawalDate +
                ", withdrawalReason='" + withdrawalReason + '\'' +
                '}';
    }
}
