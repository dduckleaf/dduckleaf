package com.greedy.dduckleaf.profile.dto;

public class ProfileDTO {

    private ProfileAttachmentDTO profileAttachment;
    private MemberDTO member;

    public ProfileDTO() {
    }

    public ProfileDTO(ProfileAttachmentDTO profileAttachment, MemberDTO member) {
        this.profileAttachment = profileAttachment;
        this.member = member;
    }

    public ProfileAttachmentDTO getProfileAttachment() {
        return profileAttachment;
    }

    public void setProfileAttachment(ProfileAttachmentDTO profileAttachment) {
        this.profileAttachment = profileAttachment;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "ProfileDTO{" +
                "profileAttachment=" + profileAttachment +
                ", member=" + member +
                '}';
    }
}
