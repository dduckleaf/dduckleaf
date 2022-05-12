package com.greedy.dduckleaf.member.entity;

import javax.persistence.*;

@Entity(name = "MemberWithdrawForMember")
@Table(name = "TBL_MEMBER_WITHDRAW")
public class MemberWithdraw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WITHDRAW_NO")
    private int withdrawNo;

    @Column(name = "WITHDRAW_REASON")
    private String withdrawReason;

    @Column(name = "WITHDRAW_DATE")
    private String withdrawDate;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    public MemberWithdraw() {
    }

    public MemberWithdraw(int withdrawNo, String withdrawReason, String withdrawDate, int memberNo) {
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
        return "MemberWithdraw{" +
                "withdrawNo=" + withdrawNo +
                ", withdrawReason='" + withdrawReason + '\'' +
                ", withdrawDate='" + withdrawDate + '\'' +
                ", memberNo=" + memberNo +
                '}';
    }
}
