package com.greedy.dduckleaf.member.dto;

public class MemberWithdrawDTO {

    private int withdrawNo;
    private String withdrawReason;
    private String withdrawDate;
    private int memberNo;

    public MemberWithdrawDTO() {
    }

    public MemberWithdrawDTO(int withdrawNo, String withdrawReason, String withdrawDate, int memberNo) {
        this.withdrawNo = withdrawNo;
        this.withdrawReason = withdrawReason;
        this.withdrawDate = withdrawDate;
        this.memberNo = memberNo;
    }

    public int getWithdrawNo() {
        return withdrawNo;
    }

    public void setWithdrawNo(int withdrawNo) {
        this.withdrawNo = withdrawNo;
    }

    public String getWithdrawReason() {
        return withdrawReason;
    }

    public void setWithdrawReason(String withdrawReason) {
        this.withdrawReason = withdrawReason;
    }

    public String getWithdrawDate() {
        return withdrawDate;
    }

    public void setWithdrawDate(String withdrawDate) {
        this.withdrawDate = withdrawDate;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    @Override
    public String toString() {
        return "MemberWithdrawDTO{" +
                "withdrawNo=" + withdrawNo +
                ", withdrawReason='" + withdrawReason + '\'' +
                ", withdrawDate='" + withdrawDate + '\'' +
                ", memberNo=" + memberNo +
                '}';
    }
}
