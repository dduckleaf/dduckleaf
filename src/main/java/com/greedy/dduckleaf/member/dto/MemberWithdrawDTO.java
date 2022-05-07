package com.greedy.dduckleaf.member.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberWithdrawDTO {

    private int withdrawNo;
    private String withdrawReason;
    private String withdrawDate;
    private int memberNo;
}
