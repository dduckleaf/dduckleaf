package com.greedy.dduckleaf.faq.dto;

public class FaqDTO {

    private int faqNo;
    private String faqTitle;
    private String faqContent;
    private String faqStatus;
    private MemberDTO member;
    private String faqSubTitle;

    public FaqDTO() {}

    public FaqDTO(int faqNo, String faqTitle, String faqContent, String faqStatus, MemberDTO member, String faqSubTitle) {
        this.faqNo = faqNo;
        this.faqTitle = faqTitle;
        this.faqContent = faqContent;
        this.faqStatus = faqStatus;
        this.member = member;
        this.faqSubTitle = faqSubTitle;
    }

    public int getFaqNo() {
        return faqNo;
    }

    public void setFaqNo(int faqNo) {
        this.faqNo = faqNo;
    }

    public String getFaqTitle() {
        return faqTitle;
    }

    public void setFaqTitle(String faqTitle) {
        this.faqTitle = faqTitle;
    }

    public String getFaqContent() {
        return faqContent;
    }

    public void setFaqContent(String faqContent) {
        this.faqContent = faqContent;
    }

    public String getFaqStatus() {
        return faqStatus;
    }

    public void setFaqStatus(String faqStatus) {
        this.faqStatus = faqStatus;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    public String getFaqSubTitle() {
        return faqSubTitle;
    }

    public void setFaqSubTitle(String faqSubTitle) {
        this.faqSubTitle = faqSubTitle;
    }

    @Override
    public String toString() {
        return "FaqDTO{" +
                "faqNo=" + faqNo +
                ", faqTitle='" + faqTitle + '\'' +
                ", faqContent='" + faqContent + '\'' +
                ", faqStatus='" + faqStatus + '\'' +
                ", member=" + member +
                ", faqSubTitle='" + faqSubTitle + '\'' +
                '}';
    }
}
