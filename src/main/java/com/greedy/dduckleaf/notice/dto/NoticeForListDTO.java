package com.greedy.dduckleaf.notice.dto;

public class NoticeForListDTO {

    private int noticeNo;
    private String noticeName;
    private String noticeContent;
    private String noticeRegistDate;
    private String noticeStatus;
    private AdminDTO admin;
    private int noticeCount;
    private NoticeCategoryDTO noticeCategoryDTO;

    public NoticeForListDTO() {}

    public NoticeForListDTO(int noticeNo, String noticeName, String noticeContent, String noticeRegistDate, String noticeStatus, AdminDTO admin, int noticeCount, NoticeCategoryDTO noticeCategoryDTO) {
        this.noticeNo = noticeNo;
        this.noticeName = noticeName;
        this.noticeContent = noticeContent;
        this.noticeRegistDate = noticeRegistDate;
        this.noticeStatus = noticeStatus;
        this.admin = admin;
        this.noticeCount = noticeCount;
        this.noticeCategoryDTO = noticeCategoryDTO;
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

    public AdminDTO getAdmin() {
        return admin;
    }

    public void setAdmin(AdminDTO admin) {
        this.admin = admin;
    }

    public int getNoticeCount() {
        return noticeCount;
    }

    public void setNoticeCount(int noticeCount) {
        this.noticeCount = noticeCount;
    }

    public NoticeCategoryDTO getNoticeCategoryDTO() {
        return noticeCategoryDTO;
    }

    public void setNoticeCategoryDTO(NoticeCategoryDTO noticeCategoryDTO) {
        this.noticeCategoryDTO = noticeCategoryDTO;
    }

    @Override
    public String toString() {
        return "NoticeForListDTO{" +
                "noticeNo=" + noticeNo +
                ", noticeName='" + noticeName + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticeRegistDate='" + noticeRegistDate + '\'' +
                ", noticeStatus='" + noticeStatus + '\'' +
                ", admin=" + admin +
                ", noticeCount=" + noticeCount +
                ", noticeCategoryDTO=" + noticeCategoryDTO +
                '}';
    }
}
