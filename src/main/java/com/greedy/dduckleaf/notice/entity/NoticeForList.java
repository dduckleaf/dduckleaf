package com.greedy.dduckleaf.notice.entity;

import javax.persistence.*;

@Entity(name = "NoticeForList")
@Table(name = "TBL_NOTICE")
public class NoticeForList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTICE_NO")
    private int noticeNo;

    @Column(name = "NOTICE_NAME")
    private String noticeName;

    @Column(name = "NOTICE_CONTENT")
    private String noticeContent;

    @Column(name = "NOTICE_REGIST_DATE")
    private String noticeRegistDate;

    @Column(name = "NOTICE_STATUS")
    private String noticeStatus;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "ADMIN_NO")
    private Admin admin;

    @Column(name = "NOTICE_COUNT")
    private int noticeCount;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "NOTICE_CATEGORY_NO")
    private NoticeCategory noticeCategory;

    public NoticeForList() {}

    public NoticeForList(int noticeNo, String noticeName, String noticeContent, String noticeRegistDate, String noticeStatus, Admin admin, int noticeCount, NoticeCategory noticeCategory) {
        this.noticeNo = noticeNo;
        this.noticeName = noticeName;
        this.noticeContent = noticeContent;
        this.noticeRegistDate = noticeRegistDate;
        this.noticeStatus = noticeStatus;
        this.admin = admin;
        this.noticeCount = noticeCount;
        this.noticeCategory = noticeCategory;
    }

    public int getNoticeNo() {
        return noticeNo;
    }

    public void setNoticeNo(int noticeNo) {
        this.noticeNo = noticeNo;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticeRegistDate() {
        return noticeRegistDate;
    }

    public void setNoticeRegistDate(String noticeRegistDate) {
        this.noticeRegistDate = noticeRegistDate;
    }

    public String getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(String noticeStatus) {
        this.noticeStatus = noticeStatus;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public int getNoticeCount() {
        return noticeCount;
    }

    public void setNoticeCount(int noticeCount) {
        this.noticeCount = noticeCount;
    }

    public NoticeCategory getNoticeCategory() {
        return noticeCategory;
    }

    public void setNoticeCategory(NoticeCategory noticeCategory) {
        this.noticeCategory = noticeCategory;
    }

    @Override
    public String toString() {
        return "NoticeForList{" +
                "noticeNo=" + noticeNo +
                ", noticeName='" + noticeName + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticeRegistDate='" + noticeRegistDate + '\'' +
                ", noticeStatus='" + noticeStatus + '\'' +
                ", admin=" + admin +
                ", noticeCount=" + noticeCount +
                ", noticeCategory=" + noticeCategory +
                '}';
    }
}
