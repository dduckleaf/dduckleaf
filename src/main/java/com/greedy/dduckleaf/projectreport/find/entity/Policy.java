package com.greedy.dduckleaf.projectreport.find.entity;

import javax.persistence.*;

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

    public Policy() {}

    public Policy(int policyNo, String policyRegistDate, PolicyCategory policyCategory, String policyExpirationDate, String policyName) {
        this.policyNo = policyNo;
        this.policyRegistDate = policyRegistDate;
        this.policyCategory = policyCategory;
        this.policyExpirationDate = policyExpirationDate;
        this.policyName = policyName;
    }

    public int getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(int policyNo) {
        this.policyNo = policyNo;
    }

    public String getPolicyRegistDate() {
        return policyRegistDate;
    }

    public void setPolicyRegistDate(String policyRegistDate) {
        this.policyRegistDate = policyRegistDate;
    }

    public PolicyCategory getPolicyCategory() {
        return policyCategory;
    }

    public void setPolicyCategory(PolicyCategory policyCategory) {
        this.policyCategory = policyCategory;
    }

    public String getPolicyExpirationDate() {
        return policyExpirationDate;
    }

    public void setPolicyExpirationDate(String policyExpirationDate) {
        this.policyExpirationDate = policyExpirationDate;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

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
