package com.greedy.dduckleaf.project.find.entity;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "MemberForProjectList")
@Table(name = "TBL_MEMBER")
public class Member {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "MEMBER_NO")
    private Farmer farmerInfo;

}
