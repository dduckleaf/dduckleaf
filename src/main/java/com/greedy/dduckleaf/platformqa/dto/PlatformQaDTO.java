package com.greedy.dduckleaf.platformqa.dto;

import java.util.List;

public class PlatformQaDTO {

    private int platformQaNo;
    private String platformQaTitle;
    private String platformQaContent;
    private String platformQaRegistDate;
    private String platformQaAnswerStatus;
    private String platformQaStatus;
    private int memberNo;
    private int platformQaCategory;
    private MemberDTO member;
    private PlatformQaCategoryDTO qnaCategory;
    private List<PlatformQaReplyDTO> platformQaReplyList;

    public PlatformQaDTO() {}

    public PlatformQaDTO(int platformQaNo, String platformQaTitle, String platformQaContent, String platformQaRegistDate, String platformQaAnswerStatus, String platformQaStatus, int memberNo, int platformQaCategory, MemberDTO member, PlatformQaCategoryDTO qnaCategory, List<PlatformQaReplyDTO> platformQaReplyList) {
        this.platformQaNo = platformQaNo;
        this.platformQaTitle = platformQaTitle;
        this.platformQaContent = platformQaContent;
        this.platformQaRegistDate = platformQaRegistDate;
        this.platformQaAnswerStatus = platformQaAnswerStatus;
        this.platformQaStatus = platformQaStatus;
        this.memberNo = memberNo;
        this.platformQaCategory = platformQaCategory;
        this.member = member;
        this.qnaCategory = qnaCategory;
        this.platformQaReplyList = platformQaReplyList;
    }

    public int getPlatformQaNo() {
        return platformQaNo;
    }

    public void setPlatformQaNo(int platformQaNo) {
        this.platformQaNo = platformQaNo;
    }

    public String getPlatformQaTitle() {
        return platformQaTitle;
    }

    public void setPlatformQaTitle(String platformQaTitle) {
        this.platformQaTitle = platformQaTitle;
    }

    public String getPlatformQaContent() {
        return platformQaContent;
    }

    public void setPlatformQaContent(String platformQaContent) {
        this.platformQaContent = platformQaContent;
    }

    public String getPlatformQaRegistDate() {
        return platformQaRegistDate;
    }

    public void setPlatformQaRegistDate(String platformQaRegistDate) {
        this.platformQaRegistDate = platformQaRegistDate;
    }

    public String getPlatformQaAnswerStatus() {
        return platformQaAnswerStatus;
    }

    public void setPlatformQaAnswerStatus(String platformQaAnswerStatus) {
        this.platformQaAnswerStatus = platformQaAnswerStatus;
    }

    public String getPlatformQaStatus() {
        return platformQaStatus;
    }

    public void setPlatformQaStatus(String platformQaStatus) {
        this.platformQaStatus = platformQaStatus;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public int getPlatformQaCategory() {
        return platformQaCategory;
    }

    public void setPlatformQaCategory(int platformQaCategory) {
        this.platformQaCategory = platformQaCategory;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    public PlatformQaCategoryDTO getQnaCategory() {
        return qnaCategory;
    }

    public void setQnaCategory(PlatformQaCategoryDTO qnaCategory) {
        this.qnaCategory = qnaCategory;
    }

    public List<PlatformQaReplyDTO> getPlatformQaReplyList() {
        return platformQaReplyList;
    }

    public void setPlatformQaReplyList(List<PlatformQaReplyDTO> platformQaReplyList) {
        this.platformQaReplyList = platformQaReplyList;
    }

    @Override
    public String toString() {
        return "PlatformQaDTO{" +
                "platformQaNo=" + platformQaNo +
                ", platformQaTitle='" + platformQaTitle + '\'' +
                ", platformQaContent='" + platformQaContent + '\'' +
                ", platformQaRegistDate='" + platformQaRegistDate + '\'' +
                ", platformQaAnswerStatus='" + platformQaAnswerStatus + '\'' +
                ", platformQaStatus='" + platformQaStatus + '\'' +
                ", memberNo=" + memberNo +
                ", platformQaCategory=" + platformQaCategory +
                ", member=" + member +
                ", qnaCategory=" + qnaCategory +
                ", platformQaReplyList=" + platformQaReplyList +
                '}';
    }
}
