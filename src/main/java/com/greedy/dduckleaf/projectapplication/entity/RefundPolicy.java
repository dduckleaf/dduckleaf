package com.greedy.dduckleaf.projectapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "refundPolicyForProjectApplication")
@Table(name = "TBL_REFUND_POLICY")
public class RefundPolicy {

    @Id
    @Column(name = "REFUND_POLICY_NO")
    private int refundPolicyNo;

    @Column(name = "REFUND_POLICY_CATEGORY")
    private String refundPolicyCategory;    //추후 삭제 예정 컬럼

    @Column(name = "REFUND_POLICY_CONTENT")
    private String refundPolicyContent;

    @Column(name = "PROJECT_NO")
    private int projectNo;
}
