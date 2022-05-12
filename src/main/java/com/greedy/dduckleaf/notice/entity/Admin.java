package com.greedy.dduckleaf.notice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "AdminForNotice")
@Table(name = "TBL_MEMBER")
public class Admin {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    public Admin() {}

    public Admin(int memberNo, String memberName) {
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
        return "Admin{" +
                "memberNo=" + memberNo +
                ", memberName='" + memberName + '\'' +
                '}';
    }
}
