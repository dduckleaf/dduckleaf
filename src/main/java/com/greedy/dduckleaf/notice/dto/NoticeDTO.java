package com.greedy.dduckleaf.notice.dto;

public class NoticeDTO {

    private int noticeNo;
    private String noticeName;
    private String noticeContent;
    private String noticeRegistDate;
    private String noticeStatus;
    private int adminNo;
    private int noticeCount;
    private int noticeCategoryNo;
    private AdminDTO admin;
    private NoticeCategoryDTO noticeCategory;

    public NoticeDTO() {}

    public NoticeDTO(int noticeNo, String noticeName, String noticeContent, String noticeRegistDate, String noticeStatus, int adminNo, int noticeCount, int noticeCategoryNo, AdminDTO admin, NoticeCategoryDTO noticeCategory) {
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

    public AdminDTO getAdmin() {
        return admin;
    }

    public void setAdmin(AdminDTO admin) {
        this.admin = admin;
    }

    public NoticeCategoryDTO getNoticeCategory() {
        return noticeCategory;
    }

    public void setNoticeCategory(NoticeCategoryDTO noticeCategory) {
        this.noticeCategory = noticeCategory;
    }

    @Override
    public String toString() {
        return "NoticeDTO{" +
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
