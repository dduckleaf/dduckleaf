package com.greedy.dduckleaf.myfunding.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "MemberCategoryForMyFunding")
@Table(name = "TBL_MEMBER_CATEGORY")
public class MemberCategory {

    @Id
    @Column(name = "MEMBER_ROLE")
    private int memberRole;

    @Column(name = "MEMBER_ROLE_NAME")
    private String memberRoleName;

    public MemberCategory() {
    }

    public MemberCategory(int memberRole, String memberRoleName) {
        this.memberRole = memberRole;
        this.memberRoleName = memberRoleName;
    }

    public int getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(int memberRole) {
        this.memberRole = memberRole;
    }

    public String getMemberRoleName() {
        return memberRoleName;
    }

    public void setMemberRoleName(String memberRoleName) {
        this.memberRoleName = memberRoleName;
    }

    @Override
    public String toString() {
        return "MemberCategory{" +
                "memberRole=" + memberRole +
                ", memberRoleName='" + memberRoleName + '\'' +
                '}';
    }
}
