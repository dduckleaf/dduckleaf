package com.greedy.dduckleaf.myfunding.entity;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "MemberForMyFunding")
@Table(name = "TBL_MEMBER")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "MEMBER_NAME")
    private String memberName;

//    @OneToMany(mappedBy = "member")
//    private List<FundingInfo> fundingInfoList;
//
//    @Override
//    public String toString() {
//        return "Member{" +
//                "memberNo=" + memberNo +
//                ", memberName='" + memberName + '\'' +
//                '}';
//    }
}
