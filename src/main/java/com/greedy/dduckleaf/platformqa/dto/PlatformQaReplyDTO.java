package com.greedy.dduckleaf.platformqa.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PlatformQaReplyDTO {

    private int platformQaReplyNo;
    private String platformQaReplyContent;
    private String platformQaReplyRegistDate;
    private String platformQaReplyStatus;
    private int platformQaNo;
    private int adminNo;
    private PlatformQaDTO platformQa;
    private MemberDTO member;
}
