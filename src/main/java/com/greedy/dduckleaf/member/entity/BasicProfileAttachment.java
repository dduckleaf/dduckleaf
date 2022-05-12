package com.greedy.dduckleaf.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    public BasicProfileAttachment() {
    }

    public BasicProfileAttachment(int basicProfileNo, String profileOriginalName, String profileSavedName, String profilePath, String profileThumbnailPath) {
        this.basicProfileNo = basicProfileNo;
        this.profileOriginalName = profileOriginalName;
        this.profileSavedName = profileSavedName;
        this.profilePath = profilePath;
        this.profileThumbnailPath = profileThumbnailPath;
    }

    public int getBasicProfileNo() {
        return basicProfileNo;
    }

    public void setBasicProfileNo(int basicProfileNo) {
        this.basicProfileNo = basicProfileNo;
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

    @Override
    public String toString() {
        return "BasicProfileAttachment{" +
                "basicProfileNo=" + basicProfileNo +
                ", profileOriginalName='" + profileOriginalName + '\'' +
                ", profileSavedName='" + profileSavedName + '\'' +
                ", profilePath='" + profilePath + '\'' +
                ", profileThumbnailPath='" + profileThumbnailPath + '\'' +
                '}';
    }
}
