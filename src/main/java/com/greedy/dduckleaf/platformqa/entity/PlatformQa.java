package com.greedy.dduckleaf.platformqa.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "PlatformQa")
@Table(name = "TBL_PLATFORM_QA")
public class PlatformQa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLATFORM_QA_NO")
    private int platformQaNo;

    @Column(name = "PLATFORM_QA_TITLE")
    private String platformQaTitle;

    @Column(name = "PLATFORM_QA_CONTENT")
    private String platformQaContent;

    @Column(name = "PLATFORM_QA_REGIST_DATE")
    private String platformQaRegistDate;

    @Column(name = "PLATFORM_QA_ANSWER_STATUS")
    private String platformQaAnswerStatus;

    @Column(name = "PLATFORM_QA_STATUS")
    private String platformQaStatus;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "PLATFORM_QA_CATEGORY")
    private int platformQaCategory;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "MEMBER_NO", insertable = false, updatable = false)
    private Member member;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "PLATFORM_QA_CATEGORY", insertable = false, updatable = false)
    private PlatformQaCategory qnaCategory;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "PLATFORM_QA_NO")
    private List<PlatformQaReply> platformQaReplyList;

    public PlatformQa() {}

    public PlatformQa(int platformQaNo, String platformQaTitle, String platformQaContent, String platformQaRegistDate, String platformQaAnswerStatus, String platformQaStatus, int memberNo, int platformQaCategory, Member member, PlatformQaCategory qnaCategory, List<PlatformQaReply> platformQaReplyList) {
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public PlatformQaCategory getQnaCategory() {
        return qnaCategory;
    }

    public void setQnaCategory(PlatformQaCategory qnaCategory) {
        this.qnaCategory = qnaCategory;
    }

    public List<PlatformQaReply> getPlatformQaReplyList() {
        return platformQaReplyList;
    }

    public void setPlatformQaReplyList(List<PlatformQaReply> platformQaReplyList) {
        this.platformQaReplyList = platformQaReplyList;
    }

    @Override
    public String toString() {
        return "PlatformQa{" +
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
