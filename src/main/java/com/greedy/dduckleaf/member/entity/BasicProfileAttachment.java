package com.greedy.dduckleaf.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "BasicProfileAttachmentForMember")
@Table(name = "TBL_BASIC_PROFILE_ATTACHMENT")
public class BasicProfileAttachment {

    @Id
    @Column(name = "BASIC_PROFILE_NO")
    private int basicProfileNo;

    @Column(name = "PROFILE_ORIGINAL_NAME")
    private String profileOriginalName;

    @Column(name = "PROFILE_SAVED_NAME")
    private String profileSavedName;

    @Column(name = "PROFILE_PATH")
    private String profilePath;

    @Column(name = "PROFILE_THUMBNAIL_PATH")
    private String profileThumbnailPath;
}
