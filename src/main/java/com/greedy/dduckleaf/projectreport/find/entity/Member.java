package com.greedy.dduckleaf.projectreport.find.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "MemberForProjectReport")
@Table(name = "TBL_MEMBER")
public class Member {

    @Id
    @Column(name = "MEMBER_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberNo;

    @Transient
    @Column(name = "MEMBER_NAME")
    private String memberName;

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

    @Transient
    @Column(name = "MEMBER_ROLE")
    private int memberRole;

    @Transient
    @Column(name = "WITHDRAWAL_STATUS")
    private String withdrawalStatus;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<ProjectReport> projectReportList;

    public Member() {}

    public Member(int memberNo, String memberName, String memberId, String memberPwd, String email, String phone,
                  int memberRole, String withdrawalStatus, List<ProjectReport> projectReportList) {
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.email = email;
        this.phone = phone;
        this.memberRole = memberRole;
        this.withdrawalStatus = withdrawalStatus;
        this.projectReportList = projectReportList;
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

    public List<ProjectReport> getProjectReportList() {
        return projectReportList;
    }

    public void setProjectReportList(List<ProjectReport> projectReportList) {
        this.projectReportList = projectReportList;
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
                ", memberRole=" + memberRole +
                ", withdrawalStatus='" + withdrawalStatus + '\'' +
                '}';
    }
}
