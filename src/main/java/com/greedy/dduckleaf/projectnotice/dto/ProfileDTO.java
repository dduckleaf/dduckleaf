package com.greedy.dduckleaf.projectnotice.dto;

import com.greedy.dduckleaf.profile.dto.MemberDTO;
import com.greedy.dduckleaf.profile.dto.ProfileAttachmentDTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProfileDTO {

    private MemberDTO member;
    private ProfileAttachmentDTO profileAttachment;

}
