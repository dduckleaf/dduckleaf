package com.greedy.dduckleaf.mockfund.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "FarmerForMockFund")
@Table(name = "TBL_MEMBER")
public class Farmer {

    @Id
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
    private int memberRole;

    @Column(name = "WITHDRAWAL_STATUS")
    private String withdrawalStatus;

    @OneToMany(mappedBy = "farmer")
    private List<MockFund> mockFundList;

    public Farmer() {}

    public Farmer(int memberNo, String memberName, String memberId, String memberPwd, String email, String phone, int memberRole, String withdrawalStatus, Date withdrawalDate, String withdrawalReason, List<MockFund> mockFundList) {
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.email = email;
        this.phone = phone;
        this.memberRole = memberRole;
        this.withdrawalStatus = withdrawalStatus;
        this.mockFundList = mockFundList;
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

    public int getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(int memberRole) {
        this.memberRole = memberRole;
    }

    public String getWithdrawalStatus() {
        return withdrawalStatus;
    }

    public void setWithdrawalStatus(String withdrawalStatus) {
        this.withdrawalStatus = withdrawalStatus;
    }

    public List<MockFund> getMockFundList() {
        return mockFundList;
    }

    public void setMockFundList(List<MockFund> mockFundList) {
        this.mockFundList = mockFundList;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "memberNo=" + memberNo +
                ", memberName='" + memberName + '\'' +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", withdrawalStatus='" + withdrawalStatus + '\'' +
                '}';
    }
}
