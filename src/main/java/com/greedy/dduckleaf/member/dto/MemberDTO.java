package com.greedy.dduckleaf.member.dto;

import org.springframework.stereotype.Controller;

public class MemberDTO {

    private int memberNo;
    private String memberName;
    private String memberId;
    private String memberPwd;
    private String email;
    private String phone;
    private String memberRole;
    private String deleteStatus;

    public MemberDTO() {
    }

    public MemberDTO(int memberNo, String memberName, String memberId, String memberPwd, String email, String phone, String memberRole, String deleteStatus) {
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.email = email;
        this.phone = phone;
        this.memberRole = memberRole;
        this.deleteStatus = deleteStatus;
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

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberNo=" + memberNo +
                ", memberName='" + memberName + '\'' +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", memberRole='" + memberRole + '\'' +
                ", deleteStatus='" + deleteStatus + '\'' +
                '}';
    }
}
