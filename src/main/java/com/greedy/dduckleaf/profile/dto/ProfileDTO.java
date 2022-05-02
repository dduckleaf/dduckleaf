package com.greedy.dduckleaf.profile.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProfileDTO {

    private ProfileAttachmentDTO profileAttachment;
    private MemberDTO member;
}
