package com.greedy.dduckleaf.funding.regist.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberDTO {
    private int memberNo;
    private String memberName;
    private String memberId;
    private String memberPwd;
    private String email;
    private String phone;
    private int memberRole;
    private String whthdrawalStatus;

}
