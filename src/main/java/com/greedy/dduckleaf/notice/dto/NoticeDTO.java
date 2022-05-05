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
    private String noticeRegistDate;
    private String noticeStatus;
    private int adminNo;
    private int noticeCount;
    private int noticeCategoryNo;

//    public NoticeEntity toEntity() {
//        NoticeEntity noticeEntity = NoticeEntity.builder()
//                .no(noticeNo)
//                .name(noticeName)
//                .content(noticeContent)
//                .registDate(noticeRegistDate)
//                .status(noticeStatus)
//                .adminNo(adminNo)
//                .count(noticeCount)
//                .categoryNo(noticeCategoryNo)
//                .build();
//
//        return noticeEntity;
//    }

//    @Builder
//    public NoticeDTO(int noticeNo, String noticeName, String noticeContent, java.sql.Date noticeRegistDate, String noticeStatus, int adminNo, int noticeCount, int noticeCategoryNo) {
//
//        this.no = noticeNo;
//        this.name = noticeName;
//
//
//
//    }
}
