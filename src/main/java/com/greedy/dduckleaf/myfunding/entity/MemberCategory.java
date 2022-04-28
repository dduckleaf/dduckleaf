package com.greedy.dduckleaf.myfunding.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "MemberCategoryForMyFunding")
@Table(name = "TBL_MEMBER_CATEGORY")
public class MemberCategory {

    @Id
    @Column(name = "MEMBER_ROLE")
    private int memberRole;

    @Column(name = "MEMBER_ROLE_NAME")
    private String memberRoleName;
}
