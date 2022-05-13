package com.greedy.dduckleaf.notice.entity;

import javax.persistence.*;

@Entity(name = "Notice")
@Table(name = "TBL_NOTICE")
public class Notice {

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

    @Column(name = "ADMIN_NO")
    private int adminNo;

    @Column(name = "NOTICE_COUNT")
    private int noticeCount;

    @Column(name = "NOTICE_CATEGORY_NO")
    private int noticeCategoryNo;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "ADMIN_NO", insertable = false, updatable = false)
    private Admin admin;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "NOTICE_CATEGORY_NO", insertable = false, updatable = false)
    private NoticeCategory noticeCategory;

    public Notice() {}

    public Notice(int noticeNo, String noticeName, String noticeContent, String noticeRegistDate, String noticeStatus, int adminNo, int noticeCount, int noticeCategoryNo, Admin admin, NoticeCategory noticeCategory) {
        this.noticeNo = noticeNo;
        this.noticeName = noticeName;
        this.noticeContent = noticeContent;
        this.noticeRegistDate = noticeRegistDate;
        this.noticeStatus = noticeStatus;
        this.adminNo = adminNo;
        this.noticeCount = noticeCount;
        this.noticeCategoryNo = noticeCategoryNo;
        this.admin = admin;
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

    public int getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(int adminNo) {
        this.adminNo = adminNo;
    }

    public int getNoticeCount() {
        return noticeCount;
    }

    public void setNoticeCount(int noticeCount) {
        this.noticeCount = noticeCount;
    }

    public int getNoticeCategoryNo() {
        return noticeCategoryNo;
    }

    public void setNoticeCategoryNo(int noticeCategoryNo) {
        this.noticeCategoryNo = noticeCategoryNo;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public NoticeCategory getNoticeCategory() {
        return noticeCategory;
    }

    public void setNoticeCategory(NoticeCategory noticeCategory) {
        this.noticeCategory = noticeCategory;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeNo=" + noticeNo +
                ", noticeName='" + noticeName + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticeRegistDate='" + noticeRegistDate + '\'' +
                ", noticeStatus='" + noticeStatus + '\'' +
                ", adminNo=" + adminNo +
                ", noticeCount=" + noticeCount +
                ", noticeCategoryNo=" + noticeCategoryNo +
                ", admin=" + admin +
                ", noticeCategory=" + noticeCategory +
                '}';
    }
}
