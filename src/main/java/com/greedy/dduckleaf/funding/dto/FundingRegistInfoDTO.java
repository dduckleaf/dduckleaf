package com.greedy.dduckleaf.funding.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FundingRegistInfoDTO {

    private List<BankDTO> bankList;
    private MemberDTO member;
    private ProjectDTO project;
}
