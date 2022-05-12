package com.greedy.dduckleaf.faq.entity;

import javax.persistence.*;

@Entity(name = "Faq")
@Table(name = "TBL_FAQ")
public class Faq {

    @Id
    @Column(name = "FAQ_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int faqNo;

    @Column(name = "FAQ_TITLE")
    private String faqTitle;

    @Column(name = "FAQ_CONTENT")
    private String faqContent;

    @Column(name = "FAQ_STATUS")
    private String faqStatus;


    @Column(name = "FAQ_SUBTITLE")
    private String faqSubTitle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ADMIN_NO")
    private Member member;

    public Faq() {}

    public Faq(int faqNo, String faqTitle, String faqContent, String faqStatus, String faqSubTitle, Member member) {
        this.faqNo = faqNo;
        this.faqTitle = faqTitle;
        this.faqContent = faqContent;
        this.faqStatus = faqStatus;
        this.faqSubTitle = faqSubTitle;
        this.member = member;
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

    public String getFaqSubTitle() {
        return faqSubTitle;
    }

    public void setFaqSubTitle(String faqSubTitle) {
        this.faqSubTitle = faqSubTitle;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Faq{" +
                "faqNo=" + faqNo +
                ", faqTitle='" + faqTitle + '\'' +
                ", faqContent='" + faqContent + '\'' +
                ", faqStatus='" + faqStatus + '\'' +
                ", faqSubTitle='" + faqSubTitle + '\'' +
                ", member=" + member +
                '}';
    }
}