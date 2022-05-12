package com.greedy.dduckleaf.projectreport.find.dto;

public class PolicyContentDTO {

    private int policyContentNo;                                    //약관 및 규정 정책 본문 번호
    private PolicyDTO policy;                                          //약관 및 규정 정책 번호
    private String policyContentTitle;                                //정책 제목
    private String policyContentDetailContent;                      //정책 내용

    public PolicyContentDTO() {}

    public PolicyContentDTO(int policyContentNo, PolicyDTO policy, String policyContentTitle, String policyContentDetailContent) {
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

    public PolicyDTO getPolicy() {
        return policy;
    }

    public void setPolicy(PolicyDTO policy) {
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
