package com.greedy.dduckleaf.platformqa.dto;

public class PlatformQaReplyDTO {

    private int platformQaReplyNo;
    private String platformQaReplyContent;
    private String platformQaReplyRegistDate;
    private String platformQaReplyStatus;
    private int platformQaNo;
    private int adminNo;
    private PlatformQaDTO platformQa;
    private MemberDTO member;

    public PlatformQaReplyDTO() {}

    public PlatformQaReplyDTO(int platformQaReplyNo, String platformQaReplyContent, String platformQaReplyRegistDate, String platformQaReplyStatus, int platformQaNo, int adminNo, PlatformQaDTO platformQa, MemberDTO member) {
        this.platformQaReplyNo = platformQaReplyNo;
        this.platformQaReplyContent = platformQaReplyContent;
        this.platformQaReplyRegistDate = platformQaReplyRegistDate;
        this.platformQaReplyStatus = platformQaReplyStatus;
        this.platformQaNo = platformQaNo;
        this.adminNo = adminNo;
        this.platformQa = platformQa;
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

    public PlatformQaDTO getPlatformQa() {
        return platformQa;
    }

    public void setPlatformQa(PlatformQaDTO platformQa) {
        this.platformQa = platformQa;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "PlatformQaReplyDTO{" +
                "platformQaReplyNo=" + platformQaReplyNo +
                ", platformQaReplyContent='" + platformQaReplyContent + '\'' +
                ", platformQaReplyRegistDate='" + platformQaReplyRegistDate + '\'' +
                ", platformQaReplyStatus='" + platformQaReplyStatus + '\'' +
                ", platformQaNo=" + platformQaNo +
                ", adminNo=" + adminNo +
                ", platformQa=" + platformQa +
                ", member=" + member +
                '}';
    }
}
