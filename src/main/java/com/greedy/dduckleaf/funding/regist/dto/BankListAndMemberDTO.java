package com.greedy.dduckleaf.funding.regist.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BankListAndMemberDTO {

    private List<BankDTO> bankList;
    private MemberDTO member;
}
