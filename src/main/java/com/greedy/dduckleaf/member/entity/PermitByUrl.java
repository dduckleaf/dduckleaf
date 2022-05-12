package com.greedy.dduckleaf.member.entity;

import javax.persistence.*;

@Entity(name = "PermitByUrl")
@Table(name = "TBL_PERMIT_BY_URL")
public class PermitByUrl {

    @Id
    @Column(name = "PERMIT_BY_URL_NO")
    private int permitByUrlNo;

    @Column(name = "MEMBER_ROLE")
    private int memberRole;

    @Column(name = "PERMIT_BY_URL")
    private String permitByUrl;

    public PermitByUrl() {
    }

    public PermitByUrl(int permitByUrlNo, int memberRole, String permitByUrl) {
        this.permitByUrlNo = permitByUrlNo;
        this.memberRole = memberRole;
        this.permitByUrl = permitByUrl;
    }

    public int getPermitByUrlNo() {
        return permitByUrlNo;
    }

    public void setPermitByUrlNo(int permitByUrlNo) {
        this.permitByUrlNo = permitByUrlNo;
    }

    public int getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(int memberRole) {
        this.memberRole = memberRole;
    }

    public String getPermitByUrl() {
        return permitByUrl;
    }

    public void setPermitByUrl(String permitByUrl) {
        this.permitByUrl = permitByUrl;
    }

    @Override
    public String toString() {
        return "PermitByUrl{" +
                "permitByUrlNo=" + permitByUrlNo +
                ", memberRole=" + memberRole +
                ", permitByUrl='" + permitByUrl + '\'' +
                '}';
    }
}
