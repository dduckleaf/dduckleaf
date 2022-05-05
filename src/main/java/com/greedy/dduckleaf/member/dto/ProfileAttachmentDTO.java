package com.greedy.dduckleaf.member.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProfileAttachmentDTO {

    private int profileNo;
    private String profileOriginalName;
    private String profileSavedName;
    private String profilePath;
    private String profileThumbnailPath;
    private int memberNo;
}
