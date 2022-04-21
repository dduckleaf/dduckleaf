package com.greedy.dduckleaf.funding.regist.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CancelFundingDTO {
    private int cancelFundingNo;
    private int cancelFundingCategoryNo;
    private String cancelFundingContent;
    private int fundingInfoNo;

}
