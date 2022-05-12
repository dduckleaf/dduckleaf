package com.greedy.dduckleaf.profile.entity;

import javax.persistence.*;

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

    public ProfileAttachment() {
    }

    public ProfileAttachment(int profileNo, String profileOriginalName, String profileSavedName, String profilePath, String profileThumbnailPath, Member member) {
        this.profileNo = profileNo;
        this.profileOriginalName = profileOriginalName;
        this.profileSavedName = profileSavedName;
        this.profilePath = profilePath;
        this.profileThumbnailPath = profileThumbnailPath;
        this.member = member;
    }

    public int getProfileNo() {
        return profileNo;
    }

    public void setProfileNo(int profileNo) {
        this.profileNo = profileNo;
    }

    public String getProfileOriginalName() {
        return profileOriginalName;
    }

    public void setProfileOriginalName(String profileOriginalName) {
        this.profileOriginalName = profileOriginalName;
    }

    public String getProfileSavedName() {
        return profileSavedName;
    }

    public void setProfileSavedName(String profileSavedName) {
        this.profileSavedName = profileSavedName;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public String getProfileThumbnailPath() {
        return profileThumbnailPath;
    }

    public void setProfileThumbnailPath(String profileThumbnailPath) {
        this.profileThumbnailPath = profileThumbnailPath;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "ProfileAttachment{" +
                "profileNo=" + profileNo +
                ", profileOriginalName='" + profileOriginalName + '\'' +
                ", profileSavedName='" + profileSavedName + '\'' +
                ", profilePath='" + profilePath + '\'' +
                ", profileThumbnailPath='" + profileThumbnailPath + '\'' +
                ", member=" + member +
                '}';
    }
}
