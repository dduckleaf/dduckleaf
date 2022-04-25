package com.greedy.dduckleaf.projectapplication.dto;

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
    private String memberRole;
    private String withdrawalStatus;

}
