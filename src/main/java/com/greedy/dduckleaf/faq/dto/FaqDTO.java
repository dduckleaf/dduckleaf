package com.greedy.dduckleaf.faq.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class FaqDTO {


    private int faqNo;
    private String faqTitle;
    private String faqContent;
    private String faqStatus;
    private MemberDTO member;
    private String faqSubTitle;
}
