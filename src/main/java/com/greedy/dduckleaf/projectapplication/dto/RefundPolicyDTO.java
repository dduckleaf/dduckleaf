package com.greedy.dduckleaf.projectapplication.dto;

public class RefundPolicyDTO {

    private int refundPolicyNo;
    private String refundPolicyCategory;
    private String refundPolicyContent;
    private int projectNo;
    private String refundPolicyAgreementStatus;
    private String refundPolicyAgreementDate;

    public RefundPolicyDTO() {
    }

    public RefundPolicyDTO(int refundPolicyNo, String refundPolicyCategory, String refundPolicyContent, int projectNo, String refundPolicyAgreementStatus, String refundPolicyAgreementDate) {
        this.refundPolicyNo = refundPolicyNo;
        this.refundPolicyCategory = refundPolicyCategory;
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

    public String getRefundPolicyCategory() {
        return refundPolicyCategory;
    }

    public void setRefundPolicyCategory(String refundPolicyCategory) {
        this.refundPolicyCategory = refundPolicyCategory;
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

    @Override
    public String toString() {
        return "RefundPolicyDTO{" +
                "refundPolicyNo=" + refundPolicyNo +
                ", refundPolicyCategory='" + refundPolicyCategory + '\'' +
                ", refundPolicyContent='" + refundPolicyContent + '\'' +
                ", projectNo=" + projectNo +
                ", refundPolicyAgreementStatus='" + refundPolicyAgreementStatus + '\'' +
                ", refundPolicyAgreementDate='" + refundPolicyAgreementDate + '\'' +
                '}';
    }
}
