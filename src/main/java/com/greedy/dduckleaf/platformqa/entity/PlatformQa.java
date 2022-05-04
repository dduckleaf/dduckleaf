package com.greedy.dduckleaf.platformqa.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
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
}
