package com.greedy.dduckleaf.platformqa.dto;

import com.greedy.dduckleaf.platformqa.entity.PlatformQa;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PlatformQaReplyDTO {

    private int platformQaReplyNo;
    private String platformQaReplyContent;
    private String platformQaRegistDate;
    private String platformQaReplyStatus;
    private int platformQaNo;
    private int adminNo;
    private PlatformQaDTO platformQa;
}
