package com.greedy.dduckleaf.projectapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "refundPolicyForProjectApplication")
@Table(name = "TBL_REFUND_POLICY")
@DynamicInsert
public class RefundPolicy {

    @Id
    @Column(name = "REFUND_POLICY_NO")
    private int refundPolicyNo;

    @Column(name = "REFUND_POLICY_CONTENT")
    private String refundPolicyContent;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "REFUND_POLICY_AGREEMENT_STATUS")
    private String refundPolicyAgreementStatus;

    @Column(name = "REFUND_POLICY_AGREEMENT_DATE")
    private String refundPolicyAgreementDate;

    @PrePersist
    public void prePersist() {

        this.refundPolicyContent = this.refundPolicyContent  == null ? "반환 정책을 작성해주세요" : this.refundPolicyContent ;
        this.refundPolicyAgreementDate = this.refundPolicyAgreementDate  == null ? java.sql.Date.valueOf(LocalDate.now()).toString() : this.refundPolicyAgreementDate ;

    }
}
