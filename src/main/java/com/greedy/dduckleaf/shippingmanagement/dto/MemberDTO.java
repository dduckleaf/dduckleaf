package com.greedy.dduckleaf.shippingmanagement.dto;

public class MemberDTO {

    private int memberNo;       //회원 번호
    private String memberName;  //회원 이름

    public MemberDTO() {}

    public MemberDTO(int memberNo, String memberName) {
        this.memberNo = memberNo;
        this.memberName = memberName;
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

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberNo=" + memberNo +
                ", memberName='" + memberName + '\'' +
                '}';
    }
}
