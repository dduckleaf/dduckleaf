package com.greedy.dduckleaf.project.entity;

import lombok.*;

import javax.persistence.*;

/**
 * <pre>
 * Class : Member
 * Comment :
 *
 * History
 * 2022-04-27 username
 * </pre>
 *
 * @author username
 * @version 1.0.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "MemberForProjectDetail")
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
