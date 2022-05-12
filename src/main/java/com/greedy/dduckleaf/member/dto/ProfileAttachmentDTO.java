package com.greedy.dduckleaf.member.dto;

public class ProfileAttachmentDTO {

    private int profileNo;
    private String profileOriginalName;
    private String profileSavedName;
    private String profilePath;
    private String profileThumbnailPath;
    private int memberNo;

    public ProfileAttachmentDTO() {
    }

    public ProfileAttachmentDTO(int profileNo, String profileOriginalName, String profileSavedName, String profilePath, String profileThumbnailPath, int memberNo) {
        this.profileNo = profileNo;
        this.profileOriginalName = profileOriginalName;
        this.profileSavedName = profileSavedName;
        this.profilePath = profilePath;
        this.profileThumbnailPath = profileThumbnailPath;
        this.memberNo = memberNo;
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

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    @Override
    public String toString() {
        return "ProfileAttachmentDTO{" +
                "profileNo=" + profileNo +
                ", profileOriginalName='" + profileOriginalName + '\'' +
                ", profileSavedName='" + profileSavedName + '\'' +
                ", profilePath='" + profilePath + '\'' +
                ", profileThumbnailPath='" + profileThumbnailPath + '\'' +
                ", memberNo=" + memberNo +
                '}';
    }
}
