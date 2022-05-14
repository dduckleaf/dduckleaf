package com.greedy.dduckleaf.funding.dto;

public class MemberDTO {

    private int memberNo;
    private String memberName;
    private String memberId;
    private String memberPwd;
    private String email;
    private String phone;
    private int memberRole;
    private String whthdrawalStatus;
    private FarmerInfoDTO farmer;

    public MemberDTO() {
    }

    public MemberDTO(int memberNo, String memberName, String memberId, String memberPwd, String email, String phone, int memberRole, String whthdrawalStatus, FarmerInfoDTO farmer) {
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.email = email;
        this.phone = phone;
        this.memberRole = memberRole;
        this.whthdrawalStatus = whthdrawalStatus;
        this.farmer = farmer;
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

    public FarmerInfoDTO getFarmer() {
        return farmer;
    }

    public void setFarmer(FarmerInfoDTO farmer) {
        this.farmer = farmer;
    }
}
