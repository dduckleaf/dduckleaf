package com.greedy.dduckleaf.funding.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    public MemberForAdmin() {
    }

    public MemberForAdmin(int memberNo, String memberName, String memberId, String memberPwd, String email, String phone, int memberRole, String whthdrawalStatus, FarmerInfo farmer, List<FundingForAdmin> fundings) {
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.email = email;
        this.phone = phone;
        this.memberRole = memberRole;
        this.whthdrawalStatus = whthdrawalStatus;
        this.farmer = farmer;
        this.fundings = fundings;
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

    public String getWhthdrawalStatus() {
        return whthdrawalStatus;
    }

    public void setWhthdrawalStatus(String whthdrawalStatus) {
        this.whthdrawalStatus = whthdrawalStatus;
    }

    public FarmerInfo getFarmer() {
        return farmer;
    }

    public void setFarmer(FarmerInfo farmer) {
        this.farmer = farmer;
    }

    public List<FundingForAdmin> getFundings() {
        return fundings;
    }

    public void setFundings(List<FundingForAdmin> fundings) {
        this.fundings = fundings;
    }

    @Override
    public String toString() {
        return "MemberForAdmin{" +
                "memberNo=" + memberNo +
                ", memberName='" + memberName + '\'' +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", memberRole=" + memberRole +
                ", whthdrawalStatus='" + whthdrawalStatus + '\'' +
                ", farmer=" + farmer +
                '}';
    }
}
