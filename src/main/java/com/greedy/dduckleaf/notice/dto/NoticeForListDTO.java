package com.greedy.dduckleaf.notice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class NoticeForListDTO {

    private int noticeNo;
    private String noticeName;
    private String noticeContent;
    private String noticeRegistDate;
    private String noticeStatus;
    private AdminDTO admin;
    private int noticeCount;
    private NoticeCategoryDTO noticeCategoryDTO;
}
