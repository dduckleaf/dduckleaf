package com.greedy.dduckleaf.profile.dto;

import com.greedy.dduckleaf.profile.entity.Member;
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
