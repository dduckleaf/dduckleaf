package com.greedy.dduckleaf.projectreport.find.entity;

import javax.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "PolicyForProjectReport")
@Table(name = "TBL_POLICY")
public class Policy {

    @Id
    @Column(name = "POLICY_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int policyNo;                                   //약관 및 규정 정책 번호

    @Column(name = "POLICY_REGIST_DATE")
    private String policyRegistDate;                        //약관 및 규정 정책 등록일자

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "POLICY_CATEGORY")
    private PolicyCategory policyCategory;                  //구분

    @Column(name = "POLICY_EXPIRATION_DATE")
    private String policyExpirationDate;                    //약관 및 규정 정책 만료일자

    @Column(name = "POLICY_NAME")
    private String policyName;                              //정책명

    @Override
    public String toString() {
        return "Policy{" +
                "policyNo=" + policyNo +
                ", policyRegistDate='" + policyRegistDate + '\'' +
                ", policyCategory=" + policyCategory +
                ", policyExpirationDate='" + policyExpirationDate + '\'' +
                '}';
    }
}
