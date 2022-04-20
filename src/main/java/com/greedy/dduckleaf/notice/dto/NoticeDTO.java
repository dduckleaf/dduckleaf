package com.greedy.dduckleaf.notice.dto;

import lombok.*;

@NoArgsConstructor  //기본생성자
@AllArgsConstructor //전체생성자초기화
@Setter
@Getter
@ToString
public class NoticeDTO {

    private int noticeNo;
    private String noticeName;
    private String noticeContent;
    private java.sql.Date noticeRegistDate;
    private String noticeStatus;
    private int adminNo;
    private int noticeCount;
    private int noticeCategoryNo;

}
