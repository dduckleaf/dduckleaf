package com.greedy.dduckleaf.platformqa.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
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
    @JoinColumn(name = "PLATFORM_QA_NO", insertable = false, updatable = false)
    private PlatformQa platformQa;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "ADMIN_NO", insertable = false, updatable = false)
    private Member member;
}
