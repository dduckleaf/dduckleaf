package com.greedy.dduckleaf.member.dto;

import org.springframework.stereotype.Controller;

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
    private String withdrawalStatus;
    private String memberJoinDate;

}
