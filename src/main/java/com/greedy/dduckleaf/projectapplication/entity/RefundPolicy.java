package com.greedy.dduckleaf.projectapplication.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;

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

    public RefundPolicy() {
    }

    public RefundPolicy(int refundPolicyNo, String refundPolicyContent, int projectNo, String refundPolicyAgreementStatus, String refundPolicyAgreementDate) {
        this.refundPolicyNo = refundPolicyNo;
        this.refundPolicyContent = refundPolicyContent;
        this.projectNo = projectNo;
        this.refundPolicyAgreementStatus = refundPolicyAgreementStatus;
        this.refundPolicyAgreementDate = refundPolicyAgreementDate;
    }

    public int getRefundPolicyNo() {
        return refundPolicyNo;
    }

    public void setRefundPolicyNo(int refundPolicyNo) {
        this.refundPolicyNo = refundPolicyNo;
    }

    public String getRefundPolicyContent() {
        return refundPolicyContent;
    }

    public void setRefundPolicyContent(String refundPolicyContent) {
        this.refundPolicyContent = refundPolicyContent;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getRefundPolicyAgreementStatus() {
        return refundPolicyAgreementStatus;
    }

    public void setRefundPolicyAgreementStatus(String refundPolicyAgreementStatus) {
        this.refundPolicyAgreementStatus = refundPolicyAgreementStatus;
    }

    public String getRefundPolicyAgreementDate() {
        return refundPolicyAgreementDate;
    }

    public void setRefundPolicyAgreementDate(String refundPolicyAgreementDate) {
        this.refundPolicyAgreementDate = refundPolicyAgreementDate;
    }

    @PrePersist
    public void prePersist() {

        this.refundPolicyContent = this.refundPolicyContent  == null ? "반환 정책을 작성해주세요" : this.refundPolicyContent ;
        this.refundPolicyAgreementDate = this.refundPolicyAgreementDate  == null ? java.sql.Date.valueOf(LocalDate.now()).toString() : this.refundPolicyAgreementDate ;

    }
}
