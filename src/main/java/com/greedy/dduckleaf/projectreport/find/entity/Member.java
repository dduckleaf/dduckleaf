package com.greedy.dduckleaf.projectreport.find.entity;

import com.greedy.dduckleaf.projectreport.find.entity.ProjectReport;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
    import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "MemberForProjectReport")
@Table(name = "TBL_MEMBER")
public class Member {

    @Id
    @Column(name = "MEMBER_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberNo;

    @Transient
    @Column(name = "MEMBER_NAME")
    private String memberName;

    @Transient
    @Column(name = "MEMBER_ID")
    private String memberId;

    @Transient
    @Column(name = "MEMBER_PWD")
    private String memberPwd;

    @Transient
    @Column(name = "EMAIL")
    private String email;

    @Transient
    @Column(name = "PHONE")
    private String phone;

    @Transient
    @Column(name = "MEMBER_ROLE")
    private int memberRole;

    @Transient
    @Column(name = "WITHDRAWAL_STATUS")
    private String withdrawalStatus;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    List<ProjectReport> projectReportList;

    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", memberName='" + memberName + '\'' +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", memberRole=" + memberRole +
                ", withdrawalStatus='" + withdrawalStatus + '\'' +
                '}';
    }
}
