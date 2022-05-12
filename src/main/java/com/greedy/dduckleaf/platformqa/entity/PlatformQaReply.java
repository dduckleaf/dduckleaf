package com.greedy.dduckleaf.platformqa.entity;

import javax.persistence.*;

@Entity(name = "PlatformQaReply")
@Table(name = "TBL_PLATFORM_QA_REPLY")
public class PlatformQaReply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLATFORM_QA_REPLY_NO")
    private int platformQaReplyNo;

    @Column(name = "PLATFORM_QA_REPLY_CONTENT")
    private String platformQaReplyContent;

    @Column(name = "PLATFORM_QA_REPLY_REGIST_DATE")
    private String platformQaReplyRegistDate;

    @Column(name = "PLATFORM_QA_REPLY_STATUS")
    private String platformQaReplyStatus;

    @Column(name = "PLATFORM_QA_NO")
    private int platformQaNo;

    @Column(name = "ADMIN_NO")
    private int adminNo;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "ADMIN_NO", insertable = false, updatable = false)
    private Member member;

    public PlatformQaReply() {}

    public PlatformQaReply(int platformQaReplyNo, String platformQaReplyContent, String platformQaReplyRegistDate, String platformQaReplyStatus, int platformQaNo, int adminNo, Member member) {
        this.platformQaReplyNo = platformQaReplyNo;
        this.platformQaReplyContent = platformQaReplyContent;
        this.platformQaReplyRegistDate = platformQaReplyRegistDate;
        this.platformQaReplyStatus = platformQaReplyStatus;
        this.platformQaNo = platformQaNo;
        this.adminNo = adminNo;
        this.member = member;
    }

    public int getPlatformQaReplyNo() {
        return platformQaReplyNo;
    }

    public void setPlatformQaReplyNo(int platformQaReplyNo) {
        this.platformQaReplyNo = platformQaReplyNo;
    }

    public String getPlatformQaReplyContent() {
        return platformQaReplyContent;
    }

    public void setPlatformQaReplyContent(String platformQaReplyContent) {
        this.platformQaReplyContent = platformQaReplyContent;
    }

    public String getPlatformQaReplyRegistDate() {
        return platformQaReplyRegistDate;
    }

    public void setPlatformQaReplyRegistDate(String platformQaReplyRegistDate) {
        this.platformQaReplyRegistDate = platformQaReplyRegistDate;
    }

    public String getPlatformQaReplyStatus() {
        return platformQaReplyStatus;
    }

    public void setPlatformQaReplyStatus(String platformQaReplyStatus) {
        this.platformQaReplyStatus = platformQaReplyStatus;
    }

    public int getPlatformQaNo() {
        return platformQaNo;
    }

    public void setPlatformQaNo(int platformQaNo) {
        this.platformQaNo = platformQaNo;
    }

    public int getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(int adminNo) {
        this.adminNo = adminNo;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "PlatformQaReply{" +
                "platformQaReplyNo=" + platformQaReplyNo +
                ", platformQaReplyContent='" + platformQaReplyContent + '\'' +
                ", platformQaReplyRegistDate='" + platformQaReplyRegistDate + '\'' +
                ", platformQaReplyStatus='" + platformQaReplyStatus + '\'' +
                ", platformQaNo=" + platformQaNo +
                ", adminNo=" + adminNo +
                ", member=" + member +
                '}';
    }
}
