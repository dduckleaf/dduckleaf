package com.greedy.dduckleaf.profile.entity;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "ProfileAttachment")
@Table(name = "TBL_PROFILE_ATTACHMENT")
public class ProfileAttachment {

    @Id
    @Column(name = "PROFILE_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profileNo;

    @Column(name = "PROFILE_ORIGINAL_NAME")
    private String profileOriginalName;

    @Column(name = "PROFILE_SAVED_NAME")
    private String profileSavedName;

    @Column(name = "PROFILE_PATH")
    private String profilePath;

    @Column(name = "PROFILE_THUMBNAIL_PATH")
    private String profileThumbnailPath;

    @OneToOne
    @JoinColumn(name = "MEMBER_NO")
    private Member member;
}
