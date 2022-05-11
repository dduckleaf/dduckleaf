package com.greedy.dduckleaf.projectreport.find.entity;

import javax.persistence.*;

@Entity(name = "PolicyContentForProjectReport")
@Table(name = "TBL_POLICY_CONTENT")
public class PolicyContent {

    @Id
    @Column(name = "POLICY_CONTENT_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int policyContentNo;                                    //약관 및 규정 정책 본문 번호

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "POLICY_NO")
    private Policy policy;                                          //약관 및 규정 정책 번호

    @Column(name = "POLICY_CONTENT_TITLE")
    private String policyContentTitle;                                //정책 제목

    @Column(name = "POLICY_CONTENT_DETAIL_CONTENT")
    private String policyContentDetailContent;                      //정책 내용

    public PolicyContent() {}

    public PolicyContent(int policyContentNo, Policy policy, String policyContentTitle, String policyContentDetailContent) {
        this.policyContentNo = policyContentNo;
        this.policy = policy;
        this.policyContentTitle = policyContentTitle;
        this.policyContentDetailContent = policyContentDetailContent;
    }

    public int getPolicyContentNo() {
        return policyContentNo;
    }

    public void setPolicyContentNo(int policyContentNo) {
        this.policyContentNo = policyContentNo;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public String getPolicyContentTitle() {
        return policyContentTitle;
    }

    public void setPolicyContentTitle(String policyContentTitle) {
        this.policyContentTitle = policyContentTitle;
    }

    public String getPolicyContentDetailContent() {
        return policyContentDetailContent;
    }

    public void setPolicyContentDetailContent(String policyContentDetailContent) {
        this.policyContentDetailContent = policyContentDetailContent;
    }

    @Override
    public String toString() {
        return "PolicyContent{" +
                "policyContentNo=" + policyContentNo +
                ", policy=" + policy +
                ", policyContentTitle=" + policyContentTitle +
                ", policyContentDetailContent='" + policyContentDetailContent + '\'' +
                '}';
    }
}
