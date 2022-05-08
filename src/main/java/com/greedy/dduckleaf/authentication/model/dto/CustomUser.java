package com.greedy.dduckleaf.authentication.model.dto;

import com.greedy.dduckleaf.member.dto.MemberDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {

    private int memberNo;
    private String memberName;
    private String memberId;
    private String memberPwd;
    private String email;
    private String phone;
    private int memberRole;
    private String withdrawalStatus;
    private String profileThumbnailPath;

    public String getProfileThumbnailPath() {
        return profileThumbnailPath;
    }

    public void setProfileThumbnailPath(String profileThumbnailPath) {
        this.profileThumbnailPath = profileThumbnailPath;
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

    public CustomUser(MemberDTO member, Collection<? extends GrantedAuthority> authorities) {
        super(member.getMemberId(), member.getMemberPwd(), authorities);
        setDetails(member);
    }

    private void setDetails(MemberDTO member) {

        this.memberNo = member.getMemberNo();
        this.memberName = member.getMemberName();
        this.memberId = member.getMemberId();
        this.memberPwd = member.getMemberPwd();
        this.email = member.getEmail();
        this.phone = member.getPhone();
        this.memberRole = member.getMemberRole();
        this.withdrawalStatus = member.getWithdrawalStatus();
    }

    @Override
    public String toString() {
        return "CustomUser{" +
                "memberNo=" + memberNo +
                ", memberName='" + memberName + '\'' +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", memberRole=" + memberRole +
                ", withdrawalStatus='" + withdrawalStatus + '\'' +
                ", profileThumbnailPath='" + profileThumbnailPath + '\'' +
                '}';
    }
}
