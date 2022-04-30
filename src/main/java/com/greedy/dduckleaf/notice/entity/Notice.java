package com.greedy.dduckleaf.notice.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
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

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "ADMIN_NO")
//    private int adminNo;
    private Admin admin;

    @Column(name = "NOTICE_COUNT")
    private int noticeCount;

//    @ManyToOne(cascade = {CascadeType.PERSIST})
    @Column(name = "NOTICE_CATEGORY_NO")
    private int noticeCategoryNo;
//    private NoticeCategory noticeCategory;
}
