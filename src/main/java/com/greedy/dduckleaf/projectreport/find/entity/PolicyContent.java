package com.greedy.dduckleaf.projectreport.find.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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
