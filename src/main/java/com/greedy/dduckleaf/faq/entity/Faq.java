package com.greedy.dduckleaf.faq.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity(name = "")
@Table(name = "TBL_FAQ")
public class Faq {

    @Id
    @Column(name = "FAQ_NO")
    @GeneratedValue
    private int faqNo;

    @Column(name = "FAQ_TITLE")
    private String faqTitle;

    @Column(name = "FAQ_CONTENT")
    private String faqContent;

    @Column(name = "FAQ_STATUS")
    private String faqStatus;

    @Column (name = "ADMIN_NO")
    private int adminNo;

    public Faq() {
    }

    public Faq(int faqNo, String faqTitle, String faqContent, String faqStatus, int adminNo) {
        this.faqNo = faqNo;
        this.faqTitle = faqTitle;
        this.faqContent = faqContent;
        this.faqStatus = faqStatus;
        this.adminNo = adminNo;
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

    public int getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(int adminNo) {
        this.adminNo = adminNo;
    }

    @Override
    public String toString() {
        return "Faq{" +
                "faqNo=" + faqNo +
                ", faqTitle='" + faqTitle + '\'' +
                ", faqContent='" + faqContent + '\'' +
                ", faqStatus='" + faqStatus + '\'' +
                ", adminNo=" + adminNo +
                '}';
    }
}
