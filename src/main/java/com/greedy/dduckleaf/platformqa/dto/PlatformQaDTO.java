package com.greedy.dduckleaf.platformqa.dto;

import com.greedy.dduckleaf.platformqa.entity.Member;
import com.greedy.dduckleaf.platformqa.entity.PlatformQaCategory;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
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
}
