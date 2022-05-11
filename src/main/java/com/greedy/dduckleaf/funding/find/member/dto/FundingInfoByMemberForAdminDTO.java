package com.greedy.dduckleaf.funding.find.member.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class FundingInfoByMemberForAdminDTO {

    private int memberNo;
    private String memberName;
    private int fundingCount;
    private String recentFundingdate;
    private int refundingCount;
}
